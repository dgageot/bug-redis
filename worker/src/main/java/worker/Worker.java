package worker;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

class Worker {
    public static void main(String[] args) {
        while (true) {
            try {
                Jedis conn = new Jedis("redis");

                conn.keys("*");
                System.err.println("Connected to redis");

                return;
            } catch (JedisConnectionException e) {
                System.err.println("Failed to connect to redis: " + e);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
