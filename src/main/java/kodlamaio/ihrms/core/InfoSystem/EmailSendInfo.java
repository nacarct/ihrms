package kodlamaio.ihrms.core.InfoSystem;

import org.springframework.stereotype.Service;

@Service
public class EmailSendInfo implements InfoService{
    @Override
    public void sendInfo(String email) {
        System.out.println("Email gönderildi : "+ email);
    }
}
