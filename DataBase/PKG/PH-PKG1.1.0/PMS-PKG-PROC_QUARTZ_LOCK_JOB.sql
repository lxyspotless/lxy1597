--job锁定存储过程，成功返回Y否则返回N
CREATE OR REPLACE procedure PROC_QUARTZ_LOCK_JOB(targetId in varchar2,--锁ID
								   targetType in varchar2,--锁类型
								   lockedDate in timestamp,--锁定时间
								   expiredDate in timestamp,--失效时间
								   isLocked out varchar2--是否锁定job成功
									) is
	countNum number(3);
	begin
		isLocked := 'N';--默认失败
		select count(1) into countNum
        from pms_quartz_job_lock
        where target_id = targetId 
        	and target_type = targetType 
        	and expired_date > expiredDate 
        	and is_effective = 'Y';
        if countNum > 0 then
        	isLocked := 'N';--已有锁且处于锁定状态，返回失败
        else
        	begin
	        	select count(1) into countNum
	        	from pms_quartz_job_lock
		        where target_id = targetId 
		        	and target_type = targetType 
		        	and is_effective = 'Y';
		        if countNum > 0 then--已有记录但锁已失效
		        	update pms_quartz_job_lock
		        	set locked_date = lockedDate,
    				expired_date = expiredDate
    				where target_id = targetId 
			        	and target_type = targetType 
			        	and is_effective = 'Y';--加锁，更新锁定时间和失效时间
			    else--没有该类型记录，新增
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
		    	isLocked := 'Y';--加锁成功，返回成功
	    	exception
	    		when dup_val_on_index then
	    		isLocked := 'N';--加锁失败，返回失败
        	end;
        end if;
	end PROC_QUARTZ_LOCK_JOB;
/