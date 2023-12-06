# Blood Work

## Roles

TestingSiteAdmin (releases slots) > Testingpeople (books a new slot) > Samplecollectionpeople (collects sample, updates workqueue) > nucleic acid testing > cdc status

Testingpeople
-Qwerty1 / Qwerty@123
(views open slot for booking (TestSlotRequest stored in enterprise getWorkqueue), has booking history(useraccount.getWorkqueue().getWorkRequestList(), Books a slot for testing
HP: RegisteredTestingPeopleWorkAreaJPanel
btnBookingActionPerformed
btnSettingsActionPerformed
btnMessagesActionPerformed

TestingpeopleAdmin
-Qwerty2 / Qwerty@123

Samplecollectionpeople
-Qwerty3 / Qwerty@123

HP: Samplecollectionpeopleworkareajpanel
ToCollectListJPanel (lists slots and test requests in them)
Starts sample collects and marks slots complete after sample collection is complete
Collection history (is empty) (filter testslotrequests: note check populateslottable in toCollectListJpanel
NucleicAcidTester
-Qwerty4 / Qwerty@123
	- Testing history (is empty) (filter testslotrequests: note check populateslottable in toCollectListJpanel
	
TestingSiteHandler
-Qwerty5 / Qwerty@123

TestingSiteAdmin
Qwerty6 / Qwerty@123
Functions
Releases and cancels slots

Panels
HP:TestingSiteAdminWorkAreaJPanel
ManageSlotsJPanel
ViewSlotsJPanel

CDCAdmin
-Qwerty7 / Qwerty@123

CDCDataHandler
-Qwerty8 / Qwerty@123

CDCInfoDistributor
-Qwerty9 / Qwerty@123

SimulationOperator
-Qwerty10 / Qwerty@123