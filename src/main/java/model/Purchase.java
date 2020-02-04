package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class Purchase {

    @EmbeddedId
    private PkPurchase id;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public String toString() {
        return "Purchase{" +
            "studentName='" + studentName + '\'' +
            ", courseName='" + courseName + '\'' +
            ", price=" + price +
            ", subscriptionDate=" + subscriptionDate +
            '}';
    }

    @Embeddable
    public static class PkPurchase implements Serializable {

        @Column(name = "course_name")
        String courseName;
        @Column(name = "student_name")
        String studentName;

        public PkPurchase(String courseName, String studentName) {
            this.courseName = courseName;
            this.studentName = studentName;
        }

        public PkPurchase() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PkPurchase that = (PkPurchase) o;
            return Objects.equals(courseName, that.courseName) &&
                Objects.equals(studentName, that.studentName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(courseName, studentName);
        }
    }
}
