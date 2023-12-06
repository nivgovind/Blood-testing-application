/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class TestRequest extends WorkRequest {
        
    private static String INITIAL_STATUS = "TestRequest initialized...";
    private static String BOOKED_STATUS = "TestReqeust has been booked...";
    private static String CANCEL_BOOK_STATUS = "TestReqeust book has been cancelled...";
    private static String COLLECTED_STATUS = "Test sample has been collected...";
    private static String ABSENT_STATUS = "Test people was absent...";
    private static String NUCLEIC_ACID_TESTED_STATUS = "TestRequest has been nucleic acid tested...";
//    private static String RELEASE_STATUS = "TestRequest released...";
//    private static String SLOT_CANCEL_STATUS = "TestSlotRequest cancelled...";
    
    private TestSlotRequest testSlotRequest;
    private boolean booked;
    private boolean bookCancelled;
//    private boolean slotCancelled;
    private boolean testAbsent;
    private boolean positive;
//    private UserAccount slotReleaser;
//    private UserAccount slotCanceller;
    private UserAccount testingPeople;
    private UserAccount sampleCollector;
    private UserAccount nucleicAcidTester;
//    private UserAccount senderToCDC;
//    private UserAccount CDCAcceptor;
//    private Date scheduleTestingDate;
//    private Date slotReleaseDate;
//    private Date slotCancelDate;
    private Date bookCancelDate;
    private Date bookDate;
    private Date collectionDate;
    private Date nucleicAcidTestDate;
//    private Date sendToCDCDate;
//    private Date CDCAcceptedDate;
    
    public TestRequest(TestSlotRequest testSlotRequest) {
        super();
        setStatus(INITIAL_STATUS);
        this.testSlotRequest = testSlotRequest;
        this.booked = false;
        this.bookCancelled = false;
//        this.slotCancelled = false;
        this.testAbsent = false;
        this.positive = false;
    }
    
    public boolean bookedButHasntCollect() {
        if (isBooked() && !isBookCancelled() && getSampleCollector() == null) {
            return true;
        }
        return false;
    }
    
    public boolean bookedButHasntTest() {
        if (isBooked() && !isBookCancelled() && getSampleCollector() != null && getNucleicAcidTester() == null) {
            return true;
        }
        return false;
    }
    
    public void book(UserAccount testingPeople) {
        setStatus(BOOKED_STATUS);
        setBookDate(new Date());
        setBooked(true);
        setTestingPeople(testingPeople);
        testingPeople.getWorkQueue().addWorkRequest(this);
    }
    
    public void cancelBook() {
        setStatus(CANCEL_BOOK_STATUS);
        setBookCancelDate(new Date());
        setBookCancelled(true);
        testSlotRequest.getTestRequestList().add(new TestRequest(testSlotRequest));
    }
    
    public void collect(UserAccount sampleCollector) {
        setStatus(COLLECTED_STATUS);
        setCollectionDate(new Date());
        setSampleCollector(sampleCollector);
    }
    
    public void markAbsent() {
        setStatus(ABSENT_STATUS);
    }
    
    public void markPositive(UserAccount tester) {
        setStatus(NUCLEIC_ACID_TESTED_STATUS);
        setNucleicAcidTestDate(new Date());
        setNucleicAcidTester(tester);
        setPositive(true);
    }
    
    public void markNegative(UserAccount tester) {
        setStatus(NUCLEIC_ACID_TESTED_STATUS);
        setNucleicAcidTestDate(new Date());
        setNucleicAcidTester(tester);
        setPositive(false);
    }
    
//    public void release(Date date) {
//        setSlotReleaseDate(date);
//        setStatus(RELEASE_STATUS);
//    }
    
//    public void cancel(Date date) {
//        setSlotCancelDate(date);
//        setStatus(SLOT_CANCEL_STATUS);
//        setSlotCancelled(true);
//    }

    public TestSlotRequest getTestSlotRequest() {
        return testSlotRequest;
    }

    public void setTestSlotRequest(TestSlotRequest testSlotRequest) {
        this.testSlotRequest = testSlotRequest;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public boolean isBookCancelled() {
        return bookCancelled;
    }

    public void setBookCancelled(boolean bookCancelled) {
        this.bookCancelled = bookCancelled;
    }

//    public boolean isSlotCancelled() {
//        return slotCancelled;
//    }
//
//    public void setSlotCancelled(boolean slotCancelled) {
//        this.slotCancelled = slotCancelled;
//    }

    public boolean isTestAbsent() {
        return testAbsent;
    }

    public void setTestAbsent(boolean testAbsent) {
        this.testAbsent = testAbsent;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }
    
    public UserAccount getTestingPeople() {
        return testingPeople;
    }

//    public UserAccount getSlotReleaser() {
//        return slotReleaser;
//    }
//
//    public void setSlotReleaser(UserAccount slotReleaser) {
//        this.slotReleaser = slotReleaser;
//    }
//
//    public UserAccount getSlotCanceller() {
//        return slotCanceller;
//    }
//
//    public void setSlotCanceller(UserAccount slotCanceller) {
//        this.slotCanceller = slotCanceller;
//    }
    public void setTestingPeople(UserAccount testingPeople) {    
        this.testingPeople = testingPeople;
    }

    public UserAccount getSampleCollector() {
        return sampleCollector;
    }

    public void setSampleCollector(UserAccount sampleCollector) {
        this.sampleCollector = sampleCollector;
    }

    public UserAccount getNucleicAcidTester() {
        return nucleicAcidTester;
    }

    public void setNucleicAcidTester(UserAccount nucleicAcidTester) {
        this.nucleicAcidTester = nucleicAcidTester;
    }

//    public UserAccount getSenderToCDC() {
//        return senderToCDC;
//    }
//
//    public void setSenderToCDC(UserAccount senderToCDC) {
//        this.senderToCDC = senderToCDC;
//    }
//
//    public UserAccount getCDCAcceptor() {
//        return CDCAcceptor;
//    }
//
//    public void setCDCAcceptor(UserAccount CDCAcceptor) {
//        this.CDCAcceptor = CDCAcceptor;
//    }
//
//    public Date getScheduleTestingDate() {
//        return scheduleTestingDate;
//    }
//
//    public void setScheduleTestingDate(Date scheduleTestingDate) {
//        this.scheduleTestingDate = scheduleTestingDate;
//    }
//
//    public Date getSlotReleaseDate() {
//        return slotReleaseDate;
//    }
//
//    public void setSlotReleaseDate(Date slotReleaseDate) {
//        this.slotReleaseDate = slotReleaseDate;
//    }
//
//    public Date getSlotCancelDate() {
//        return slotCancelDate;
//    }
//
//    public void setSlotCancelDate(Date slotCancelDate) {
//        this.slotCancelDate = slotCancelDate;
//    }

    public Date getBookCancelDate() {
        return bookCancelDate;
    }

    public void setBookCancelDate(Date bookCancelDate) {
        this.bookCancelDate = bookCancelDate;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Date getNucleicAcidTestDate() {
        return nucleicAcidTestDate;
    }

    public void setNucleicAcidTestDate(Date nucleicAcidTestDate) {
        this.nucleicAcidTestDate = nucleicAcidTestDate;
    }

//    public Date getSendToCDCDate() {
//        return sendToCDCDate;
//    }
//
//    public void setSendToCDCDate(Date sendToCDCDate) {
//        this.sendToCDCDate = sendToCDCDate;
//    }
//
//    public Date getCDCAcceptedDate() {
//        return CDCAcceptedDate;
//    }
//
//    public void setCDCAcceptedDate(Date CDCAcceptedDate) {
//        this.CDCAcceptedDate = CDCAcceptedDate;
//    }
    
    @Override
    public String toString() {
        return getStatus();
    }
    
}
