package linking;

public class Linking {

    public static String X = "The Avengers began as a group of extraordinary individuals who were "
            + "assembled to defeat Loki and his Chitauri army in New York City. Since "
            + "then, the team has expanded its roster and "
            + "faced a host of new threats, while dealing with their own turmoil.";
    public static String Y = "The Avengers Initiative was the brainchild of S.H.I.E.L.D. Director "
            + "Nick Fury. He first approached Tony Stark with the idea, following Tony’s "
            + "defeat of Obadiah Stane and his subsequent public announcement that he was Iron Man. "
            + "Fury kept his eye on several potential members, as Bruce Banner struggled with life as "
            + "the Hulk, the Asgardian Thor appeared on Earth, and Steve Rogers, AKA World War II hero "
            + "Captain America, was discovered alive decades after his apparent death.";
//    public static String X = "nice phrase you";
//    public static String Y ="ok nice phrase";
//https://www.marvel.com/teams-and-groups/avengers/on-screen

    public static void main(String[] args) {
        Post postX = new Post(X);
        Post postY = new Post(Y);
        Correlation correlation = new Correlation(postX, postY);
        log("total matched words = " + correlation.matchPostsWords());
        log("the matched phrases with the longest math found");
        correlation.matchPostsPhrases();
    }

    private static void log(String output) {
        System.out.println(output);
    }

}
