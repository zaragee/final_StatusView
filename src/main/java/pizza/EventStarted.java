package pizza;

public class EventStarted extends AbstractEvent {

    private Long id;
    private String eventStatus;
    private String eventKind;
    private Long giftId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }
    public String getEventKind() {
        return eventKind;
    }

    public void setEventKind(String eventKind) {
        this.eventKind = eventKind;
    }
    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
    }
}