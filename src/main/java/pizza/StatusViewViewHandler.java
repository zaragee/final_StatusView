package pizza;

import pizza.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StatusViewViewHandler {


    @Autowired
    private StatusViewRepository statusViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {
            if (ordered.isMe()) {
                // view 객체 생성
                StatusView statusView = new StatusView();
                // view 객체에 이벤트의 Value 를 set 함
                statusView.setOrderId(ordered.getId());
                statusView.setOrderStatus(ordered.getOrderStatus());
                // view 레파지 토리에 save
                statusViewRepository.save(statusView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenEventStarted_then_CREATE_2 (@Payload EventStarted eventStarted) {
        try {
            if (eventStarted.isMe()) {
                // view 객체 생성
                StatusView statusView = new StatusView();
                // view 객체에 이벤트의 Value 를 set 함
                statusView.setEventId(eventStarted.getId());
                statusView.setEventStatus(eventStarted.getEventStatus());
                // view 레파지 토리에 save
                statusViewRepository.save(statusView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (paid.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByOrderId(paid.getOrderId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setOrderStatus(paid.getPaymentStatus());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_2(@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByOrderId(orderCanceled.getId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setOrderStatus(orderCanceled.getOrderStatus());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_3(@Payload PaymentCanceled paymentCanceled) {
        try {
            if (paymentCanceled.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByOrderId(paymentCanceled.getOrderId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setOrderStatus(paymentCanceled.getPaymentStatus());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_4(@Payload Delivered delivered) {
        try {
            if (delivered.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByOrderId(delivered.getOrderId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setDeliveryStatus(delivered.getDeliveryStatus());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenStoppedEvent_then_UPDATE_5(@Payload StoppedEvent stoppedEvent) {
        try {
            if (stoppedEvent.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByEventId(stoppedEvent.getId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setEventStatus(stoppedEvent.getEventStatus());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenGiftAdded_then_UPDATE_6(@Payload GiftAdded giftAdded) {
        try {
            if (giftAdded.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByEventId(giftAdded.getEventId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setEventStatus(giftAdded.getEventStatus());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenStoppedGift_then_UPDATE_7(@Payload StoppedGift stoppedGift) {
        try {
            if (stoppedGift.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByEventId(stoppedGift.getEventId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setEventStatus(stoppedGift.getEventStatus());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}