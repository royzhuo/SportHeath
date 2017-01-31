import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

/**
 * @author roy.zhuo
 */
public class TestRedis {
    Jedis jedis = null;

    {
        jedis = new Jedis("127.0.0.1", 6380);
    }

    @Test
    public void testPing() {

        System.out.println(jedis.ping());
    }

    @Test
    public void testAPIString() {
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");
        System.out.println("key:" + jedis.get("k3"));
        System.out.println("keys:" + jedis.keys("*"));
    }

    @Test
    public void testTX() {
        Transaction transaction = jedis.multi();
        transaction.set("k1", "vvvv111");
        transaction.del("k6");
        //transaction.exec();//执行事物
        transaction.discard();//取消事物
    }

    @Test
    public void testTransformMoney() {
        //事物模拟转账
        TX tx = new TX();
        boolean isSuccess = tx.testTransMoney(jedis);
        System.out.println("is Success:" + isSuccess);
    }

    @Test
    public void testJedisPool() {
        JedisPool jedisPool1 = JedisPoolUtil.getInstance();
        JedisPool jedisPool2 = JedisPoolUtil.getInstance();
        System.out.println(jedisPool1 == jedisPool2);
        Jedis jedis = jedisPool1.getResource();
        Jedis jedis2 = jedisPool1.getResource();
        System.out.println(jedis == jedis2);
        try {
            jedis.set("jjjjj", "ksdjkslf");
            jedis2.set("j2", "j2");
            jedis2.set("jjjjj", "jj");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisPoolUtil.realse(jedisPool1, jedis);
        }

    }
}
