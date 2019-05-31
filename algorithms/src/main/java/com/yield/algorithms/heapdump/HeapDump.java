package com.yield.algorithms.heapdump;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * @author yzd
 * @des
 * @date 2018/9/13
 */
public class HeapDump {

    public static void main(String[] args) {
        for(int i=0;i<10000000;i++) {
            try {
                Cipher cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
