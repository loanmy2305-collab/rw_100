package entity;

import java.util.Date;

public class Group {
    int id;
    String GroupName;
    Date createDate;
    Account creator;
    Account[] accounts;


    public Group(){
    }

    public Group(String GroupName,Account creator,Account[] accounts,Date createDate ){
        this.GroupName = GroupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }
    public class Account {
        String username;

        public Account(String username) {
            this.username = username;
        }
    }
    public Group(String GroupName,Account creator,String[] usernames,Date createDate ) {
        this.GroupName = GroupName;
        this.creator = creator;
        this.createDate = createDate;
        this.accounts = new Account[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            this.accounts[i] = new Account(usernames[i]);
        }
    }
}
