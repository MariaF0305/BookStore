import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Student.class, name = "Student"),
        @JsonSubTypes.Type(value = RegularCustomer.class, name = "Regular"),
        @JsonSubTypes.Type(value = Teacher.class, name = "Teacher") }
)

public abstract class User implements Serializable {
        public User(){};
        private String mFirstName;
        private String mName;
        private String mCategory;
        private int mAge;
        private long mID;

        int credit;

        private String name;

        public User(String pFirstName, String pName, String pCategory, int pAge, long pID, String userType) {
            this.mFirstName = pFirstName;
            this.mName = pName;
            this.mCategory = pCategory;
            this.mAge = pAge;
            this.mID = pID;
            this.credit = 100;
            this.name = userType;
        }

        @Override
        public boolean equals(Object obj) {
            User tmp = (User)obj;
            return (this.mFirstName.equals(tmp.getFirstName()) && this.mName.equals(tmp.getLastName()));
        }

         public String getName(){
            return name;
         }


        @Override
        public String toString() { return (this.mName + " " + this.mFirstName + " Credit: " + this.credit); }

        public void payCredit(int credit){
            this.credit = this.credit - credit;
        }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mName;
    }

    public void setLastName(String mName) {
        this.mName = mName;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }

    public long getID() {
        return mID;
    }

    public void setID(long mID) {
        this.mID = mID;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setName(String userType) {
        this.name = userType;
    }

}
