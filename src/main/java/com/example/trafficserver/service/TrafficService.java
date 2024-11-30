package com.example.trafficserver.service;

import com.example.trafficserver.dto.MyResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class TrafficService {
    public MyResult exec(HttpServletRequest request) {
        // 클라이언트 IP
        String clientIp = request.getRemoteAddr();

        try {
            // 0~500ms 사이의 랜덤 sleep
            long sleepTime = ThreadLocalRandom.current().nextInt(0, 501);
            Thread.sleep(sleepTime);

            System.out.println("[SUCCESS]" + clientIp + " sleep time: " + sleepTime);
            return new MyResult(0, "success");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 인터럽트 상태 복구

            System.out.println("[ERROR]" + clientIp);
            return new MyResult(9999, "error");
        }
    }

    public HttpStatus getHttpStatus(MyResult result) {
        return result.getResultCode() == 200 ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
