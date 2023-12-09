/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TestSlotRequest extends WorkRequest{
    
    private static String INITIAL_STATUS = "Initialized";
    private static String RELEASE_STATUS = "Released";
    private static String CANCEL_STATUS = "Cancelled";
    private static String SAMPLE_COLLECTING_STATUS = "In Collection";
    private static String SAMPLE_COLLECTION_COMPLETED_STATUS = "Collection complete";
    private static String NUCLEIC_ACID_TESTING_STATUS = "Testing in progress";
    private static String NUCLEIC_ACID_TEST_COMPLETED_STATUS = "Sent to CDC";
    private static String SEND_TO_CDC_STATUS = "In Certification";
    private static String CDC_ACCEPTED_STATUS = "Testing complete";
    
    private List<TestRequest> testRequestList;
    private int capacity;
    private boolean cancelled;
    private boolean sampleCollecting;
    private boolean sampleCollectionCompleted;
    private boolean nucleicAcidTesting;
    private boolean nucleicAcidTestCompleted;
    private boolean sendToCDC;
    private boolean CDCAccepted;
    private UserAccount slotReleaser;
    private UserAccount slotCanceller;
    private UserAccount senderToCDC;
    private UserAccount CDCAcceptor;
    private Date scheduledTestingDate;
    private Date slotReleaseDate;
    private Date cancelDate;
    private Date sampleCollectionCompletedDate;
    private Date nucleicAcidTestCompletedDate;
    private Date sendToCDCDate;
    private Date CDCAcceptedDate;

    public TestSlotRequest(UserAccount slotReleaser, Date scheduledTestingDate, int capacity) {
        super();
        this.slotReleaser = slotReleaser;
        this.scheduledTestingDate = scheduledTestingDate;
        this.capacity = capacity;
        
        this.testRequestList = new ArrayList<>();
        for (int i=0; i<capacity; i++) {
            testRequestList.add(new TestRequest(this));
        }
        
        this.cancelled = false;
        this.sampleCollecting = false;
        this.sampleCollectionCompleted = false;
        this.nucleicAcidTesting = false;
        this.nucleicAcidTestCompleted = false;
        this.sendToCDC = false;
        this.CDCAccepted = false;
        setStatus(INITIAL_STATUS);
    }
    
    public TestRequest bookOneTest(UserAccount testingPeople) {
        for (TestRequest tr : testRequestList) {
            if (!tr.isBooked()) {
                tr.book(testingPeople);
                return tr;
            }
        }
        return null;
    }
    
    public void markIsSampleCollecting() {
        sampleCollecting = true;
    }
    
    public void markSampleCollectionCompleted() {
        sampleCollecting = false;
        sampleCollectionCompleted = true;
    }
    
    public void markIsNucleicAcidTesting() {
        nucleicAcidTesting = true;
    }
    
    public void markNucleicAcidTestCompleted() {
        nucleicAcidTesting = false;
        nucleicAcidTestCompleted = true;
    }
    
    public boolean isFull() {
        if (calcBookedRequestsHistorically() - calcBookCancelledRequests() == capacity) {
            return true;
        }
        return false;
    }
    
    public void collectAllSamples(UserAccount loginAccount) {
        for (TestRequest tr : testRequestList) {
            if (tr.bookedButHasntCollect()) {
                tr.collect(loginAccount);
            }
        }
    }
    
    public int calcBookedRequestsHistorically() {
        int i = 0;
        for (TestRequest tr : testRequestList) {
            if (tr.isBooked()) {
                i ++;
            }
        }
        return i;
    }
    
    public int calcBookCancelledRequests() {
        int i = 0;
        for (TestRequest tr : testRequestList) {
            if (tr.isBooked() && tr.isBookCancelled()) {
                i ++;
            }
        }
        return i;
    }
    
    public int calcAbsentRequests() {
        int i = 0;
        for (TestRequest tr : testRequestList) {
            if (tr.isBooked() && tr.isTestAbsent()) {
                i ++;
            }
        }
        return i;
    }
    
    public int calcBookedStatus() {
        return calcBookedRequestsHistorically() - calcBookCancelledRequests();
    }
    
    public int calcPositiveRequests() {
        int i = 0;
        for (TestRequest tr : testRequestList) {
            if (tr.isBooked() && tr.isPositive()) {
                i ++;
            }
        }
        return i;
    }
    
    public int calcPresentRequests() {
        int i = calcBookedStatus() - calcAbsentRequests();
        
        return i;
    }
    
    public void release() {
        Date releaseDate = new Date();
        setSlotReleaseDate(releaseDate);
        setStatus(RELEASE_STATUS);
        
//        for (TestRequest tr : testRequestList) {
//            tr.release(slotReleaseDate);
//        }
    }
    
    public void cancel() {
        Date cancelDate = new Date();
        setCancelDate(cancelDate);
        setStatus(CANCEL_STATUS);
        setCancelled(true);
        
        for (TestRequest tr : testRequestList) {
            tr.setStatus(CANCEL_STATUS);
        }
    }
    
    public void sampleCollecting() {
        setStatus(SAMPLE_COLLECTING_STATUS);
        setSampleCollecting(true);
    }
    
    public void sampleCollectionCompleted() {
        Date completedDate = new Date();
        setSampleCollectionCompletedDate(completedDate);
        setStatus(SAMPLE_COLLECTION_COMPLETED_STATUS);
        setSampleCollectionCompleted(true);
        setSampleCollecting(false);
    }
    
    public void nucleicAcidTesting() {
        setStatus(NUCLEIC_ACID_TESTING_STATUS);
        setNucleicAcidTesting(true);
    }
    
    public void nucleicAcidTestCompleted() {
        Date completedDate = new Date();
        setNucleicAcidTestCompletedDate(completedDate);
        setStatus(NUCLEIC_ACID_TEST_COMPLETED_STATUS);
        setNucleicAcidTestCompleted(true);
        setNucleicAcidTesting(false);
    }
    
    public void sendToCDC() {
        Date sendDate = new Date();
        setSendToCDCDate(sendDate);
        setStatus(SEND_TO_CDC_STATUS);
        setSendToCDC(true);
    }
    
    public void CDCAccept() {
        Date acceptDate = new Date();
        setCDCAcceptedDate(acceptDate);
        setStatus(CDC_ACCEPTED_STATUS);
        setCDCAccepted(true);
    }

    public List<TestRequest> getTestRequestList() {
        return testRequestList;
    }

    public void setTestRequestList(List<TestRequest> testRequestList) {
        this.testRequestList = testRequestList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isSampleCollecting() {
        return sampleCollecting;
    }

    public void setSampleCollecting(boolean sampleCollecting) {
        this.sampleCollecting = sampleCollecting;
    }

    public boolean isSampleCollectionCompleted() {
        return sampleCollectionCompleted;
    }

    public void setSampleCollectionCompleted(boolean sampleCollectionCompleted) {
        this.sampleCollectionCompleted = sampleCollectionCompleted;
    }

    public boolean isNucleicAcidTesting() {
        return nucleicAcidTesting;
    }

    public void setNucleicAcidTesting(boolean nucleicAcidTesting) {
        this.nucleicAcidTesting = nucleicAcidTesting;
    }

    public boolean isNucleicAcidTestCompleted() {
        return nucleicAcidTestCompleted;
    }

    public void setNucleicAcidTestCompleted(boolean nucleicAcidTestCompleted) {
        this.nucleicAcidTestCompleted = nucleicAcidTestCompleted;
    }

    public boolean isSendToCDC() {
        return sendToCDC;
    }

    public void setSendToCDC(boolean sendToCDC) {
        this.sendToCDC = sendToCDC;
    }

    public boolean isCDCAccepted() {
        return CDCAccepted;
    }

    public void setCDCAccepted(boolean CDCAccepted) {
        this.CDCAccepted = CDCAccepted;
    }

    public UserAccount getSlotReleaser() {
        return slotReleaser;
    }

    public void setSlotReleaser(UserAccount slotReleaser) {
        this.slotReleaser = slotReleaser;
    }

    public UserAccount getSlotCanceller() {
        return slotCanceller;
    }

    public void setSlotCanceller(UserAccount slotCanceller) {
        this.slotCanceller = slotCanceller;
    }

    public UserAccount getSenderToCDC() {
        return senderToCDC;
    }

    public void setSenderToCDC(UserAccount senderToCDC) {
        this.senderToCDC = senderToCDC;
    }

    public UserAccount getCDCAcceptor() {
        return CDCAcceptor;
    }

    public void setCDCAcceptor(UserAccount CDCAcceptor) {
        this.CDCAcceptor = CDCAcceptor;
    }
    
    public Date getScheduledTestingDate() {
        return scheduledTestingDate;
    }

    public void setScheduledTestingDate(Date scheduledTestingDate) {
        this.scheduledTestingDate = scheduledTestingDate;
    }

    public Date getSlotReleaseDate() {
        return slotReleaseDate;
    }

    public void setSlotReleaseDate(Date slotReleaseDate) {
        this.slotReleaseDate = slotReleaseDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Date getSampleCollectionCompletedDate() {
        return sampleCollectionCompletedDate;
    }

    public void setSampleCollectionCompletedDate(Date sampleCollectionCompletedDate) {
        this.sampleCollectionCompletedDate = sampleCollectionCompletedDate;
    }

    public Date getNucleicAcidTestCompletedDate() {
        return nucleicAcidTestCompletedDate;
    }

    public void setNucleicAcidTestCompletedDate(Date nucleicAcidTestCompletedDate) {
        this.nucleicAcidTestCompletedDate = nucleicAcidTestCompletedDate;
    }

    public Date getSendToCDCDate() {
        return sendToCDCDate;
    }

    public void setSendToCDCDate(Date sendToCDCDate) {
        this.sendToCDCDate = sendToCDCDate;
    }

    public Date getCDCAcceptedDate() {
        return CDCAcceptedDate;
    }

    public void setCDCAcceptedDate(Date CDCAcceptedDate) {
        this.CDCAcceptedDate = CDCAcceptedDate;
    }
    
    @Override
    public String toString() {
        return getStatus();
    }
    
}
