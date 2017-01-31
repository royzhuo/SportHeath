import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author roy.zhuo
 */
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool;

    //jedis连接池 单例模式的jedis连接池
    private JedisPoolUtil() {
    }

    public static JedisPool getInstance() {
        if (null == jedisPool) {
            synchronized (JedisPoolUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPoolConfig.setMaxIdle(32);//pool中最多有多少个状态为空闲的redis实例
                    jedisPoolConfig.setMaxWaitMillis(100 * 1000);//设置redis的最大等待时间
                    jedisPoolConfig.setTestOnBorrow(true);//接通行测试 ping
                    jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6380);
                }
            }
        }
        return jedisPool;
    }

    public static void realse(JedisPool jedisPool, Jedis jedis) {
        if (null != jedisPool) {
            jedisPool.returnResourceObject(jedis);
        }
    }
}
