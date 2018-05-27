drop procedure if exists PROC_QUARTZ_LOCK_JOB;
create procedure PROC_QUARTZ_LOCK_JOB(in targetId varchar(100),-- ��ID
								   in targetType varchar(100),-- ������
								   in lockedDate timestamp,-- ����ʱ��
								   in expiredDate timestamp,-- ʧЧʱ��
								   out isLocked varchar(1)-- �Ƿ�����job�ɹ�,�ɹ�����Y���򷵻�N
									)
	begin
		declare countNum int default 0;
		DECLARE CONTINUE HANDLER FOR SQLEXCEPTION set isLocked = 'N';-- ����ʧ�ܣ�����ʧ��
		set isLocked = 'N';-- Ĭ��ʧ��
		select count(1) into countNum
        from pms_quartz_job_lock
        where target_id = targetId 
        	and target_type = targetType 
        	and expired_date > expiredDate 
        	and is_effective = 'Y';
        if countNum > 0 then
        	set isLocked = 'N';-- �������Ҵ�������״̬������ʧ��
        else
        	begin
	        	select count(1) into countNum
	        	from pms_quartz_job_lock
		        where target_id = targetId 
		        	and target_type = targetType 
		        	and is_effective = 'Y';
		        if countNum > 0 then-- ���м�¼������ʧЧ
		        	update pms_quartz_job_lock
		        	set locked_date = lockedDate,
							expired_date = expiredDate
							where target_id = targetId 
			        	and target_type = targetType 
			        	and is_effective = 'Y';-- ��������������ʱ���ʧЧʱ��
				else-- û�и����ͼ�¼������
					insert into pms_quartz_job_lock(
						target_id,
						target_type,
						locked_date,
						expired_date,
						is_effective
					)values(
						targetId,
						targetType,
						lockedDate,
						expiredDate,
						'Y');
				end if;
				set isLocked = 'Y';-- �����ɹ������سɹ�
			end;
        end if;
	end;
