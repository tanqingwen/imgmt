package cn.happyworlds.imgmt.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class KeyStores {

    public static KeyStore loadKeyStore(String certName) throws Exception {
        File certFile = new File(certName);
        return loadKeyStore(certFile);
    }

    public static KeyStore loadKeyStore(File certFile) throws Exception {
        return loadKeyStore(new FileInputStream(certFile));
    }

    public static KeyStore loadKeyStore(InputStream certIn) throws Exception {
        InputStream ins = certIn;
        try {
            // 读取证书
            CertificateFactory cerFactory = CertificateFactory.getInstance("X.509"); // 问1
            Certificate cer = cerFactory.generateCertificate(ins);
            // 创建一个证书库，并将证书导入证书库
            KeyStore keyStore = KeyStore.getInstance("PKCS12", "BC"); // 问2
            keyStore.load(null, null);
            keyStore.setCertificateEntry("trust", cer);
            return keyStore;
        } finally {
            if (certIn != null) {
                certIn.close();
            }
        }
    }

}
