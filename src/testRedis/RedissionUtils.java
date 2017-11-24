package testRedis;

import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RBucket;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RDeque;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RQueue;
import org.redisson.api.RSet;
import org.redisson.api.RSortedSet;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissionUtils {
	private static RedissionUtils redisUtils;  
    
    private RedissionUtils(){}  
      
    /** 
     * �ṩ����ģʽ 
     * @return 
     */  
    public static RedissionUtils getInstance(){  
        if(redisUtils==null)   
            synchronized (RedissionUtils.class) {  
                if(redisUtils==null) 
                	redisUtils = new RedissionUtils();  
            }  
        return redisUtils;  
    } 
      
    /** 
     * ʹ��ip��ַ�Ͷ˿ڴ���Redisson 
     * @param ip 
     * @param port 
     * @return 
     */  
    public RedissonClient getRedisson(String ip,String port){  
        Config config=new Config();  
        config.useSingleServer().setAddress(ip+":"+port);  
        RedissonClient redisson = Redisson.create(config);  
        System.out.println("�ɹ�����Redis Server"+"\t"+"����"+ip+":"+port+"������");  
        return redisson;  
    }  
      
    /** 
     * �ر�Redisson�ͻ������� 
     * @param redisson 
     */  
    public void closeRedisson(RedissonClient redisson){  
        redisson.shutdown();  
        System.out.println("�ɹ��ر�Redis Client����");  
    }  
      
    /** 
     * ��ȡ�ַ������� 
     * @param redisson 
     * @param t 
     * @param objectName 
     * @return 
     */  
    public <T> RBucket<T> getRBucket(RedissonClient redisson,String objectName){  
        RBucket<T> bucket=redisson.getBucket(objectName);  
        return bucket;  
    }  
      
    /** 
     * ��ȡMap���� 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <K,V> RMap<K, V> getRMap(RedissonClient redisson,String objectName){  
        RMap<K, V> map=redisson.getMap(objectName);  
        return map;  
    }  
      
    /** 
     * ��ȡ���򼯺� 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RSortedSet<V> getRSortedSet(RedissonClient redisson,String objectName){  
        RSortedSet<V> sortedSet=redisson.getSortedSet(objectName);  
        return sortedSet;  
    }  
      
    /** 
     * ��ȡ���� 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RSet<V> getRSet(RedissonClient redisson,String objectName){  
        RSet<V> rSet=redisson.getSet(objectName);  
        return rSet;  
    }  
      
    /** 
     * ��ȡ�б� 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RList<V> getRList(RedissonClient redisson,String objectName){  
        RList<V> rList=redisson.getList(objectName);  
        return rList;  
    }  
      
    /** 
     * ��ȡ���� 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RQueue<V> getRQueue(RedissonClient redisson,String objectName){  
        RQueue<V> rQueue=redisson.getQueue(objectName);  
        return rQueue;  
    }  
      
    /** 
     * ��ȡ˫�˶��� 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RDeque<V> getRDeque(RedissonClient redisson,String objectName){  
        RDeque<V> rDeque=redisson.getDeque(objectName);  
        return rDeque;  
    }  
      
    /** 
     * �˷�����������Redisson 1.2 ��  
     * ��1.2.2�汾�� ���� 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    /** 
    public <V> RBlockingQueue<V> getRBlockingQueue(Redisson redisson,String objectName){ 
        RBlockingQueue rb=redisson.getBlockingQueue(objectName); 
        return rb; 
    }*/  
      
    /** 
     * ��ȡ�� 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public RLock getRLock(RedissonClient redisson,String objectName){  
        RLock rLock=redisson.getLock(objectName);  
        return rLock;  
    }  
      
    /** 
     * ��ȡԭ���� 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public RAtomicLong getRAtomicLong(RedissonClient redisson,String objectName){  
        RAtomicLong rAtomicLong=redisson.getAtomicLong(objectName);  
        return rAtomicLong;  
    }  
      
    /** 
     * ��ȡ������ 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public RCountDownLatch getRCountDownLatch(RedissonClient redisson,String objectName){  
        RCountDownLatch rCountDownLatch=redisson.getCountDownLatch(objectName);  
        return rCountDownLatch;  
    }  
      
    /** 
     * ��ȡ��Ϣ��Topic 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <M> RTopic<M> getRTopic(RedissonClient redisson,String objectName){  
         RTopic<M> rTopic=redisson.getTopic(objectName);  
         return rTopic;  
    }  
}