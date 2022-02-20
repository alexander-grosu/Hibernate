import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pass = "bobik750";

        //base schema in resources folder

        String select1 = "SELECT name, registration_date " +
                "FROM skillbox.students ORDER BY registration_date";

        String select2 = "SELECT name, students_count, duration, price \n" +
                "FROM skillbox.courses \n" +
                "WHERE students_count > 4 AND duration > 10\n" +
                "ORDER BY price DESC LIMIT 5";

        String select3 = "(SELECT name AS student_teacher_course, age AS age_duration\n" +
                "FROM skillbox.students ORDER BY age LIMIT 3)\n" +
                "UNION\n" +
                "(SELECT name, age\n" +
                "FROM skillbox.teachers ORDER BY age DESC LIMIT 3)\n" +
                "UNION\n" +
                "(SELECT name, duration \n" +
                "FROM skillbox.courses ORDER BY duration DESC LIMIT 3)";

        String select4 = "SELECT AVG(age) AS average_age\n" +
                "FROM skillbox.teachers WHERE salary > 10000 ";

        String select5 = "SELECT type AS all_courses_type, SUM(price) AS sum_price\n" +
                "FROM skillbox.courses WHERE type = 'DESIGN'";

        String select6 = "SELECT type AS all_courses_type, SUM(duration) * 60 AS duration_min\n" +
                "FROM skillbox.courses WHERE type = 'PROGRAMMING'";

        String select7 = "SELECT students.name AS name, SUM(courses.duration) AS all_courses_duration " +
                "FROM skillbox.students JOIN skillbox.subscriptions JOIN skillbox.courses\n" +
                "WHERE students.id = subscriptions.student_id AND courses.id = subscriptions.course_id \n" +
                "GROUP BY students.id ORDER BY students.name";

        String select8 = "SELECT teachers.name AS teacher_name, AVG(students.age) AS avg_students_age\n" +
                "FROM skillbox.teachers JOIN skillbox.courses JOIN skillbox.subscriptions JOIN skillbox.students\n" +
                "WHERE teachers.id = courses.teacher_id " +
                "AND courses.id = subscriptions.course_id " +
                "AND subscriptions.student_id = students.id\n" +
                "GROUP BY teachers.id ORDER BY teachers.name ";

        String select9 = "SELECT courses.type AS course_type, AVG(teachers.salary) AS avg_teachers_salary\n" +
                "FROM skillbox.courses JOIN skillbox.teachers\n" +
                "WHERE teachers.id = courses.teacher_id " +
                "GROUP BY courses.type " +
                "ORDER BY AVG(teachers.salary) DESC";

        try {

            Connection connection = DriverManager
                    .getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            System.out.println("EXAMPLE 1 \n" +
                    ">>> SELECT average teachers salary by course type\n");
            ResultSet resultSet1 = statement.executeQuery(select9);
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("course_type")
                        + "  |  " + Math.ceil(Double.parseDouble(resultSet1.getString("avg_teachers_salary")))
                        + " RUR");
            }


            System.out.println("\nEXAMPLE 2 \n" +
                    ">>> SELECT 5 most expensive courses where duration > 10 hours and students count > 4 \n");
            ResultSet resultSet2 = statement.executeQuery(select2);
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("name")
                        + "\n\t\t> students count: " + resultSet2.getString("students_count")
                        + "\n\t\t> duration: " + resultSet2.getString("duration")
                        + "\n\t\t> price: " + resultSet2.getString("price"));
            }

            resultSet1.close();
            resultSet2.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
