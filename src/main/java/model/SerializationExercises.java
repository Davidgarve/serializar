package model;

import com.google.gson.Gson;

import java.io.*;

public class SerializationExercises {
    /*
        Should define the class for the concepts Movie, Theater and Session.
        A session is a play of movie in a theater.
        Create 2 instances of each class and relate among them.
        Serialize to Json all objects and save then in different files.
     */

    public static class Exercise1 {
        public static void main(String[] args) throws IOException {
            Movie film1 = new Movie("Titanic", "James Cameron", "Drama");
            Movie film2 = new Movie("Jumanji", "Jake Kasdan", "Adventure");
            Theater theater1 = new Theater("Teatro Real", 1736);
            Theater theater2 = new Theater("Gran Teatro del Liceo", 2292);
            Session session1 = new Session(film1, theater1);
            Session session2 = new Session(film2, theater2);

            Gson gson = new Gson();

            try {
                String movie1Json = gson.toJson(film1);
                String movie2Json = gson.toJson(film2);
                String theater1Json = gson.toJson(theater1);
                String theater2Json = gson.toJson(theater2);
                String session1Json = gson.toJson(session1);
                String session2Json = gson.toJson(session2);

                saveToFile("movie1.json", movie1Json);
                saveToFile("movie2.json", movie2Json);
                saveToFile("theater1.json", theater1Json);
                saveToFile("theater2.json", theater2Json);
                saveToFile("session1.json", session1Json);
                saveToFile("session2.json", session2Json);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        static void saveToFile(String file, String json) throws IOException {
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        }

    }

    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream
     */
    public static class Exercise2 {

        public static Movie deserializeMovie(String file) throws IOException{
            Gson gson = new Gson();
            FileReader fr = new FileReader(String.valueOf(file));
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            fr.close();
            br.close();
            return gson.fromJson(line, Movie.class);
        }
        public static Theater deserializeTheater(String file) throws IOException{
            Gson gson = new Gson();
            FileReader fr = new FileReader(String.valueOf(file));
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            fr.close();
            br.close();
            return gson.fromJson(line, Theater.class);
        }
        public static Session deserializeSession(String file) throws IOException{
            Gson gson = new Gson();
            FileReader fr = new FileReader(String.valueOf(file));
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            fr.close();
            br.close();
            return gson.fromJson(line, Session.class);
        }
        public static void main(String[] args) throws IOException {
            Movie film1 = deserializeMovie("movie1.json");
            Movie film2 = deserializeMovie("movie2.json");
            Theater theater1 = deserializeTheater("theater1.json");
            Theater theater2 = deserializeTheater("theater2.json");
            Session session1 = deserializeSession("movie1.json");
            Session session2 = deserializeSession("session1.json");
            System.out.println(film1);
            System.out.println(film2);
            System.out.println(theater1);
            System.out.println(theater2);
            System.out.println(session1);
            System.out.println(session2);

            Gson gson = new Gson();

            try {
                serialize("movie11.json", film1);
                serialize("movie22.json", film2);
                serialize("theater11.json", theater1);
                serialize("theater22.json", theater2);
                serialize("session11.json", session1);
                serialize("session22.json", session2);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        static void serialize(String file, Object o) throws IOException{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
        }

    }

    /*
       Deserialize the objects from the binary files created in exercise 2.
    */
    public static class Exercise3 {

        public static void main(String[] args) {
            Movie film1 = new Movie("Titanic", "James Cameron", "Drama");
            Movie film2 = new Movie("Jumanji", "Jake Kasdan", "Adventure");
            Theater theater1 = new Theater("Teatro Real", 1736);
            Theater theater2 = new Theater("Gran Teatro del Liceo", 2292);
            Session session1 = new Session(film1, theater1);
            Session session2 = new Session(film2, theater2);

            try {
                deserialize("movie11.json", film1);
                deserialize("movie22.json", film2);
                deserialize("theater11.json", theater1);
                deserialize("theater22.json", theater2);
                deserialize("session11.json", session1);
                deserialize("session22.json", session2);
                System.out.println(film1);
                System.out.println(film2);
                System.out.println(theater1);
                System.out.println(theater2);
                System.out.println(session1);
                System.out.println(session2);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);

            }


        }

        static void deserialize(String file, Object o) throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            objectInputStream.readObject();
            objectInputStream.close();
        }


    }
}
