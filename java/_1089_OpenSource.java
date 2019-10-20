/**
 * Problem: 1089 - Open Source
 *
 * Description:
 *  At an open-source fair held at a major university, leaders of open-source
 *  projects put sign-up sheets on the wall, with the project name at the top in
 *  capital letters for identification. Students then signed up for projects
 *  using their userids. A userid is a string of lower-case letters and numbers
 *  starting with a letter. The organizer then took all the sheets off the wall
 *  and typed in the information. Your job is to summarize the number of students
 *  who have signed up for each project. Some students were overly enthusiastic
 *  and put their name down several times for the same project. That's okay, but
 *  they should only count once. Students were asked to commit to a single
 *  project, so any student who has signed up for more than one project should
 *  not count for any project. There are at most 10000 students at the
 *  university, and at most 100 projects were advertised.
 *
 * Input specification:
 *  The input contains several test cases, each one ending with a line that starts
 *  with the digit 1. The last test case is followed by a line starting with the
 *  digit 0. Each test case consists of one or more project sheets. A project sheet
 *  consists of a line containing the project name in capital letters, followed by
 *  the userids of students, one per line.
 *
 * Output specification:
 *  For each test case, output a summary of each project sheet. The summary is one
 *  line with the name of the project followed by the number of students who signed
 *  up. These lines should be printed in decreasing order of number of signups. If
 *  two or more projects have the same number of signups, they should be listed in
 *  alphabetical order.
 *
 * Sample input:
 *  UBQTS TXT
 *  tthumb
 *  LIVESPACE BLOGJAM
 *  philton
 *  aeinstein
 *  YOUBOOK
 *  j97lee
 *  sswxyzy
 *  j97lee
 *  aeinstein
 *  SKINUX
 *  1
 *  0
 *
 * Sample output:
 *  YOUBOOK 2
 *  LIVESPACE BLOGJAM 1
 *  UBQTS TXT 1
 *  SKINUX 0
 *
 * URL:http://coj.uci.cu/24h/problem.xhtml?pid=1089
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class _1089_OpenSource {
  private static enum LineType { PROJECT, STUDENT, END }

  static class Project implements Comparable<Project> {
    final String name;
    final HashSet<String> students;

    Project(String name) {
      this.name = name;
      students = new HashSet<>();
    }

    @Override
    public int compareTo(Project p) {
      if (students.size() > p.students.size()) {
        return -1;
      } else if (students.size() < p.students.size()) {
        return 1;
      }
      return name.compareTo(p.name);
    }

    void addStudent(String userId) { students.add(userId); }

    boolean contains(String userId) {
      if (students.contains(userId)) {
        students.remove(userId);
        return true;
      }
      return false;
    }

    void remove(String userId) { students.remove(userId); }
    
    @Override
    public String toString() {
      return String.format("%s %d", name, students.size());
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String line = in.readLine();
    ArrayList<Project> projects = new ArrayList<>();
    HashSet<String> repeatedStudent = new HashSet<>();
    int index = -1;

    while (line.charAt(0) != '0') {
      LineType type = getLineType(line);

      switch (type) {
      case PROJECT:
        projects.add(new Project(line));
        ++index;
        break;
      case STUDENT:
        if (repeatedStudent.contains(line)) {
          break;
        }
        projects.get(index).addStudent(line);
        boolean repeated = false;
        for (int i = index - 1; i >= 0; i--) {
          if (projects.get(i).contains(line)) {
            // There should not be any back instance of this user
            repeated = true;
            break;
          }
        }

        if (repeated) {
          repeatedStudent.add(line);
          projects.get(index).remove(line);
        }
        break;
      case END:
        index = -1;
        Collections.sort(projects);
        for (Project p : projects) {
          out.write(p.toString());
          out.newLine();
        }
        projects = new ArrayList<>();
        break;
      }
      line = in.readLine();
    }

    out.close();
    in.close();
  }

  private static LineType getLineType(String line) {
    if (line.equals("1")) {
      return LineType.END;
    } else if (line.charAt(0) >= 'a') {
      return LineType.STUDENT;
    } else {
      return LineType.PROJECT;
    }
  }
}