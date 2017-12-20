--job�����洢���̣��ɹ�����Y���򷵻�N
CREATE OR REPLACE procedure PROC_QUARTZ_LOCK_JOB(targetId in varchar2,--��ID
								   targetType in varchar2,--������
								   lockedDate in timestamp,--����ʱ��
								   expiredDate in timestamp,--ʧЧʱ��
								   isLocked out varchar2--�Ƿ�����job�ɹ�
									) is
	countNum number(3);
	begin
		isLocked := 'N';--Ĭ��ʧ��
		select count(1) into countNum
        from pms_quartz_job_lock
        where target_id = targetId 
        	and target_type = targetType 
        	and expired_date > expiredDate 
        	and is_effective = 'Y';
        if countNum > 0 then
        	isLocked := 'N';--�������Ҵ�������״̬������ʧ��
        else
        	begin
	        	select count(1) into countNum
	        	from pms_quartz_job_lock
		        where target_id = targetId 
		        	and target_type = targetType 
		        	and is_effective = 'Y';
		        if countNum > 0 then--���м�¼������ʧЧ
		        	update pms_quartz_job_lock
		        	set locked_date = lockedDate,
    				expired_date = expiredDate
    				where target_id = targetId 
			        	and target_type = targetType 
			        	and is_effective = 'Y';--��������������ʱ���ʧЧʱ��
			    else--û�и����ͼ�¼������
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
		    	isLocked := 'Y';--�����ɹ������سɹ�
	    	exception
	    		when dup_val_on_index then
	    		isLocked := 'N';--����ʧ�ܣ�����ʧ��
        	end;
        end if;
	end PROC_QUARTZ_LOCK_JOB;
/