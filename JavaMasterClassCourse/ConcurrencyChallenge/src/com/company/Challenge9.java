package com.company;

// wait() can cause a deadlock if not used correctly
    // Because the method results in a thread releasing a lock before it has exited the synchronised block,
    // and this premature (albeit temporary) release can lead to problems if we're not careful

public class Challenge9 {
    public static void main(String[] args) {
        final NewTutor tutor = new NewTutor();
        final NewStudent student = new NewStudent(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
    }
}

class NewTutor {
    private NewStudent student;

    public void setStudent(NewStudent student) {
        this.student = student;
    }

    // FIX:
    // Just moved the synchronised student lock outside of tutor so when tutor lock is release, student lock isn't stuck locked away. Many other ways still like .join(), etc
    public void studyTime() {

        synchronized (this) {
            System.out.println("Tutor has arrived");
            try {
                // wait for student to arrive
                this.wait();    // This is releasing the Tutor Lock so student thread runs and then the students lock needs the tutor but he has it so it deadlocks
            } catch (InterruptedException e) {

            }
            synchronized (student) {
                student.startStudy();
                System.out.println("Tutor is studying with student");
            }
        }
    }



    public void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}

class NewStudent {

    private NewTutor tutor;

    NewStudent(NewTutor tutor) {
        this.tutor = tutor;
    }

    public void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    public void handInAssignment() {
        synchronized (tutor) {
            tutor.getProgressReport();
            synchronized (this) {
                System.out.println("Student handed in assignment");
                tutor.notifyAll();
            }
        }
    }
}
