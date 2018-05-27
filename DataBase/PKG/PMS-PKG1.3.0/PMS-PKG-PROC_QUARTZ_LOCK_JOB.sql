drop procedure if exists PROC_QUARTZ_LOCK_JOB;
create procedure PROC_QUARTZ_LOCK_JOB(in targetId varchar(100),-- 锁ID
								   in targetType varchar(100),-- 锁类型
								   in lockedDate timestamp,-- 锁定时间
								   in expiredDate timestamp,-- 失效时间
								   out isLocked varchar(1)-- 是否锁定job成功,成功返回Y否则返回N
									)
	begin
		declare countNum int default 0;
		DECLARE CONTINUE HANDLER FOR SQLEXCEPTION set isLocked = 'N';-- 加锁失败，返回失败
		set isLocked = 'N';-- 默认失败
		select count(1) into countNum
        from pms_quartz_job_lock
        where target_id = targetId 
        	and target_type = targetType 
        	and expired_date > expiredDate 
        	and is_effective = 'Y';
        if countNum > 0 then
        	set isLocked = 'N';-- 已有锁且处于锁定状态，返回失败
        else
        	begin
	        	select count(1) into countNum
	        	from pms_quartz_job_lock
		        where target_id = targetId 
		        	and target_type = targetType 
		        	and is_effective = 'Y';
		        if countNum > 0 then-- 已有记录但锁已失效
		        	update pms_quartz_job_lock
		        	set locked_date = lockedDate,
							expired_date = expiredDate
							where target_id = targetId 
			        	and target_type = targetType 
			        	and is_effective = 'Y';-- 加锁，更新锁定时间和失效时间
				else-- 没有该类型记录，新增
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
				set isLocked = 'Y';-- 加锁成功，返回成功
			end;
        end if;
	end;
