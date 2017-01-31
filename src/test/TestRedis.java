import org.junit.Test;
import redis.clients.jedis.Jedis;
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
}
