# Blood Work

# deliverables
1) A running swing application that addresses the challenges outlined aboveat an eco-system scale. A typical implementation must include the
participation of at least 4 enterprises, 4-8 organizations, and 4-6 roles.
2) A presentation that outlines details specific to the design and
implementation of your solution. This must include, the definition of the problem you solved, stakeholder and their contributions,use-cases, design, and implementation techniques followed. You must explain why each enterprise is essential to delivering the total value as outlined in your problem statement. .
3) A robust role-based authentication module with strong user name and
password capabilities. (done)
4) A reporting module with summarized view of the data in your system. This could include performance data that is important at the system or network level.
5) A configuration module with test cases that will populate your model and show the correctness of your solution. You might want to integrate with a Faker module from faker.com for random data generation.

# Setup instructions
- add the jar files in (home)Libraries folder to the (blood-work)libraries within the bloodwork project for db4o and javax/mail
 - clean and build the project again


## Roles

TestingSiteAdmin (releases slots) > Testingpeople (books a new slot) > Samplecollectionpeople (collects sample, updates workqueue) > nucleic acid testing > cdc status

# To do
- [ ] History panel
	- [x] Testing pending and testing completed (Niv)
	- [x] Slot history (Niv)
	- [x] Collection history (Niv)
	- [x] NAT history (Niv)
	- [ ] CDC History (Shreya)
- [ ] CDC (Shreya)
- [x] Disease choices (Niv)
- [ ] Email / messaging feature (shubank)
- [ ] Misc 
	- [ ] change authors
	- [ ] change content 
	- [ ] UI changes 
- [ ] Admin - charts and shit (deliverables 4) (shubank)
- [ ] Prepopulate database (shubank)


# Testingpeople
-Qwerty1 / Qwerty@123
(views open slot for booking (TestSlotRequest stored in enterprise getWorkqueue), has booking history(useraccount.getWorkqueue().getWorkRequestList(), Books a slot for testing
HP: RegisteredTestingPeopleWorkAreaJPanel
btnBookingActionPerformed
btnSettingsActionPerformed
btnMessagesActionPerformed

# TestingpeopleAdmin
-Qwerty2 / Qwerty@123

# Samplecollectionpeople
-Qwerty3 / Qwerty@123

HP: Samplecollectionpeopleworkareajpanel
ToCollectListJPanel (lists slots and test requests in them)
Starts sample collects and marks slots complete after sample collection is complete
Collection history (is empty) (filter testslotrequests: note check populateslottable in toCollectListJpanel

# NucleicAcidTester
-Qwerty4 / Qwerty@123
	- Testing history (is empty) (filter testslotrequests: note check populateslottable in toCollectListJpanel
	
# TestingSiteHandler
-Qwerty5 / Qwerty@123

# TestingSiteAdmin
Qwerty6 / Qwerty@123
Functions
Releases and cancels slots

Panels
HP:TestingSiteAdminWorkAreaJPanel
ManageSlotsJPanel
ViewSlotsJPanel

# CDCAdmin
-Qwerty7 / Qwerty@123

# CDCDataHandler
-Qwerty8 / Qwerty@123

# CDCInfoDistributor
-Qwerty9 / Qwerty@123

# SimulationOperator
-Qwerty10 / Qwerty@123