
    public class CreateAcc{
        private String name;
        private String email;
        private long phone;
        private int balance;
        private String password;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public long getPhone() {
            return phone;
        }
        public void setPhone(long phone) {
            this.phone = phone;
        }
        public int getBalance() {
            return balance;
        }
        public void setBalance(int balance) {
            this.balance = balance;
        }
        public void setDeposit(int amt) {
            this.balance = balance+amt;
        }
        public void setWithdraw(int amt) {
            this.balance = balance-amt;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
                
    }

