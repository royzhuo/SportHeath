import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author roy.zhuo
 */
public class TX {


    public boolean testTransMoney(Jedis jedis) {
        int balance = 0; //信用卡可用余额
        int dept = 0;   //欠款
        int jiekuan = 10;//借款


        dept = Integer.parseInt(jedis.get("dept"));

        jedis.watch("balance");//监控可用余额
        System.out.println("目前余额:" + balance);
        //模拟高并发情况下，balance在事物开始前，被另一个线程修改时，所做的回滚
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = Integer.parseInt(jedis.get("balance"));
        if (balance < jiekuan) {
            jedis.unwatch();
            System.out.println("余额不足");
            return false;
        } else {
            System.out.println("transaction is start");
            Transaction transaction = jedis.multi();
            transaction.decrBy("balance", jiekuan);
            transaction.incrBy("dept", jiekuan);
            transaction.exec();
            System.out.println("-----balance:" + jedis.get("balance"));
            System.out.println("-----dept:" + jedis.get("dept"));
            return true;
        }

    }
}
