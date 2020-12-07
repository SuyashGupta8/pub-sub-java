package pojo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Notifications {

    private class NotificationData {
        Map<String, String> data = new ConcurrentHashMap<>();
    }

    private String notificationType;
    private String notificationRequestType;
    private String bannerId;
    private String locale;
    private boolean saveInFireStore;
    private String patientEmailId;
    private String patientMobileNo;
    private String patientId;
    private String prescriptionId;
    private String storeId;

    public NotificationData getNotificationData() {
        return notificationData;
    }

    public void setNotificationData(NotificationData notificationData) {
        this.notificationData = notificationData;
    }

    private NotificationData notificationData;


    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationRequestType() {
        return notificationRequestType;
    }

    public void setNotificationRequestType(String notificationRequestType) {
        this.notificationRequestType = notificationRequestType;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public boolean isSaveInFireStore() {
        return saveInFireStore;
    }

    public void setSaveInFireStore(boolean saveInFireStore) {
        this.saveInFireStore = saveInFireStore;
    }

    public String getPatientEmailId() {
        return patientEmailId;
    }

    public void setPatientEmailId(String patientEmailId) {
        this.patientEmailId = patientEmailId;
    }

    public String getPatientMobileNo() {
        return patientMobileNo;
    }

    public void setPatientMobileNo(String patientMobileNo) {
        this.patientMobileNo = patientMobileNo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

}
