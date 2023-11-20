import java.io.Serializable;

public abstract class User implements Serializable {
        private String mFirstName;
        private String mName;
        private String mCategory;
        private int mAge;
        private long mID;

        int credit;

        private String userType;

        public User(String pFirstName, String pName, String pCategory, int pAge, long pID, String userType) {
            this.mFirstName = pFirstName;
            this.mName = pName;
            this.mCategory = pCategory;
            this.mAge = pAge;
            this.mID = pID;
            this.credit = 100;
        }

        public String getFirstName() { return this.mFirstName; }

        public String getName() {
            return this.mName;
        }

        public String getCategory () { return this.mCategory; }

        public int getAge() {
            return this.mAge;
        }

        public long getID() {
            return this.mID;
        }

        @Override
        public boolean equals(Object obj) {
            User tmp = (User)obj;
            return (this.mFirstName.equals(tmp.getFirstName()) && this.mName.equals(tmp.getName()));
        }

         public String getUserType(){
            return userType;
         }


        @Override
        public String toString() { return (this.mName + " " + this.mFirstName + " Credit: " + this.credit); }

        public void payCredit(int credit){
            this.credit = this.credit - credit;
        }
}
