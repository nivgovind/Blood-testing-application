/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import java.util.Arrays;

/**
 *
 * @author nivcodes
 */
public class Faker {
    public static int count = 0;
    public String[] names = {
        "Amelia", "Oliver", "Ava", "Liam", "Sophia", "Jackson", "Olivia", "Lucas",
         "Emma", "Aiden", "Mia", "Layla", "Caden", "Chloe", "Elijah", "Madison", 
         "Harper", "Mason", "Abigail", "Avery", "Ella", "Logan", "Scarlett", "Aria", 
         "Zoe", "Nora", "Camila", "Riley", "Evelyn", "Owen", "Lily", "Penelope", 
         "Aurora", "Carter", "Luke", "Grace", "Landon", "Natalie", "Hazel", "Levi", 
         "Lillian", "Isaac", "Mila", "Ezra", "Elizabeth", "Hudson", "Addison", "Sofia",
          "Wyatt", "Victoria", "Gabriel", "Stella", "Lila", "Nathan", "Hannah", "Grayson", 
          "Aaliyah", "Lucy", "Paisley", "Eli", "Skylar", "Benjamin", "Nevaeh", "Eva", "Colton", 
          "Ellie", "Piper", "Isaiah", "Adeline", "Brooklyn", "Leah", "Makayla", "Bentley", "Audrey",
           "Maya", "Caleb", "Aubrey", "Cameron", "Ariana", "Gabriella", "Luna", "Kinsley", "Claire",
           "Amaya", "Julian", "Adrian", "Eliana", "Charlotte", "Easton", "Violet", "Anthony", 
           "Emilia", "Brayden", "Chloe", "Nova", "Alice", "Gianna", "Bella", "Leo", "Serenity",
            "Samuel", "Alexa", "Zara", "Elena", "Dylan", "Noah", "Peyton", "Brielle", "Kaylee",
            "Riley", "Alexis", "Sophia", "Michael", "Emily", "Lillian", "Kinsley", "Zachary",
            "Savannah", "Paisley", "Arianna", "Violet", "Grayson", "Audrey", "Zara", "Peyton",
            "Gabriel", "Liam", "Luna", "Jackson", "Harper", "Hannah", "Leah", "Evelyn", "Sophie",
            "Madison", "Chloe", "Mila", "Lily", "Nathan", "Penelope", "Isabella", "Aiden", 
            "Riley", "Amelia", "Olivia", "Elijah", "Mia", "Charlotte", "Ella", "Zoe", "Zachary",
            "Lillian", "Aubrey", "Scarlett", "Nova", "Mateo", "Ellie", "Aurora", "Stella",
            "Nora", "Hudson", "Serenity", "Claire", "Eva", "Harper", "Leo", "Aria", "Piper", 
            "Eleanor", "Eli", "Avery", "Victoria", "Oliver", "Kylie", "Brooklyn", "Eleanor",
            "Peyton", "Hannah", "Ava", "Madison", "Taylor", "Brielle", "Piper", "Kaylee", 
            "Riley", "Hudson", "Aubrey", "Makayla", "Logan", "Alexis", "Aiden", "Ariana", 
            "Sophia", "Scarlett", "Michael", "Claire", "Skylar", "Emily", "Noah", "Lillian", 
            "Nora", "Kinsley", "Eli", "Aaliyah", "Zachary", "Brooklyn", "Savannah", "Samantha", 
            "Paisley", "Ella", "Arianna", "Hazel", "Julian", "Violet", "Lucy", "Grayson", "Audrey", 
            "Grace", "Zara", "Peyton", "Sofia", "Liam", "Luna", "Jackson", "Harper", "Avery", 
            "Hannah", "Leah", "Evelyn", "Sophie", "Madison", "Aria", "Chloe", "Mila", "Lily", 
            "Nathan", "Penelope", "Isabella", "Aiden", "Riley", "Amelia", "Olivia", "Elijah", 
            "Mia", "Charlotte", "Ella", "Zoe", "Zachary", "Lillian", "Aubrey", "Scarlett", "Nova", 
            "Ariana", "Mateo", "Ellie", "Aurora", "Stella", "Lucas", "Hazel", "Oliver", "Claire", 
            "Eva", "Arianna", "Grace", "Harper", "Leo", "Aria", "Piper", "Eleanor", "Eli", "Lily", 
            "Averi", "Madison", "Isaac", "Mila", "Zoey", "Chase", "Levi", "Victoria", "Aubrey", 
            "Aiden", "Charlotte", "Kinsley", "Logan", "Bella", "Sophia", "Zara", "Brooklyn", 
            "Addison", "Mason", "Ameliaa"
    };

    public void faker() {
        Arrays.sort(names);
    }

    public String getName() {
        if (count == names.length) {
            count = 0;
        }
        return names[count++];
    }
}
