import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Department
        Department dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Sale";

        Department dep2 = new Department();
        dep2.id = 2;
        dep2.name = "Marketing";

        Department dep3 = new Department();
        dep3.id = 3;
        dep3.name = "Bảo vệ";

        // Position
        Position pos1 = new Position();
        pos1.id = 1;
        pos1.name = Position.PositionName.PM;

        Position pos2 = new Position();
        pos2.id = 2;
        pos2.name = Position.PositionName.DEV;

        Position pos3 = new Position();
        pos3.id = 3;
        pos3.name = Position.PositionName.TEST;


        // Account
        Account acc1 = new Account();
        acc1.id = 1;
        acc1.username = "Loan";
        acc1.fullname = "Nguyen Thi Loan";
        acc1.position = pos1;
        acc1.department = dep1;
        acc1.createDate = LocalDate.of(2026,5,23);

        Account acc2 = new Account();
        acc2.id = 2;
        acc2.username = "My";
        acc2.fullname = "Nguyen Thi Tra My";
        acc2.position = pos1;
        acc2.department = dep1;
        acc2.createDate = LocalDate.of(2017,7,07);

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.username = "Huy";
        acc3.fullname = "Nguyen Gia Huy";
        acc3.position = pos1;
        acc3.department = dep1;
        acc3.createDate = LocalDate.of(2020,2,19);

        // Group
        Group Group1 = new Group();
        Group1.id = 1;
        Group1.name = "My";
        Group1.creator = acc1;
        Group1.createDate = LocalDate.now();

        Group Group2 = new Group();
        Group2.id = 2;
        Group2.name = "An";
        Group2.creator = acc1;
        Group2.createDate = LocalDate.now();

        Group Group3 = new Group();
        Group3.id = 3;
        Group3.name = "Bao";
        Group3.creator = acc1;
        Group3.createDate = LocalDate.now();

        // GroupAccount
        GroupAccount groupAccount1 = new GroupAccount();
        groupAccount1.group = groupAccount1.group;
        groupAccount1.account = acc1;
        groupAccount1.joinDate = LocalDate.now();

        GroupAccount groupAccount2 = new GroupAccount();
        groupAccount2.group = groupAccount1.group;
        groupAccount2.account = acc1;
        groupAccount2.joinDate = LocalDate.now();

        GroupAccount groupAccount3 = new GroupAccount();
        groupAccount3.group = groupAccount1.group;
        groupAccount3.account = acc1;
        groupAccount3.joinDate = LocalDate.now();

        // TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.id = 1;
        typeQuestion1.name = TypeQuestion.TypeQuestionName.Essay;

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.id = 2;
        typeQuestion2.name = TypeQuestion.TypeQuestionName.MultipleChoice;

        // CategoryQuestion
        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        categoryQuestion1.id = 1;
        categoryQuestion1.name = "Java";

        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.id = 2;
        categoryQuestion2.name = "NET";

        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion3.id = 3;
        categoryQuestion3.name = "SQL";

        // Question
        Question question1 = new Question();
        question1.id = 1;
        question1.content = "Hôm nay ngày bao nhiêu?";
        question1.category = categoryQuestion1;
        question1.type = typeQuestion1;
        question1.creator = acc1;
        question1.createDate = LocalDate.now();

        Question question2 = new Question();
        question2.id = 2;
        question2.content = "Hôm nay thứ mấy?";
        question2.category = categoryQuestion1;
        question2.createDate = LocalDate.now();

        Question question3 = new Question();
        question3.id = 3;
        question3.content = "Hôm nay ăn gì?";
        question3.category = categoryQuestion1;
        question3.createDate = LocalDate.now();

        // Answer
        Answer answer1 = new Answer();
        answer1.id = 1;
        answer1.conten = "Hôm nay ngày bao nhiêu?";
        answer1.isCorrect = true;
        answer1.question = question1;

        Answer answer2 = new Answer();
        answer2.id = 2;
        answer2.conten = "A?";
        answer2.isCorrect = false;
        answer2.question = question1;

        Answer answer3 = new Answer();
        answer3.id = 3;
        answer3.conten = "B?";
        answer3.isCorrect = true;
        answer3.question = question1;

        //Exam
        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "ABC123";
        exam1.category = categoryQuestion1;
        exam1.Creator =acc1;
        exam1.Duration = 60;
        exam1.title = "SQL";
        exam1.createDate = LocalDate.now();

        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "DEF123";
        exam2.category = categoryQuestion1;
        exam2.Creator =acc1;
        exam2.Duration = 70;
        exam2.title = "NET";
        exam2.createDate = LocalDate.now();

        Exam exam3 = new Exam();
        exam3.id = 3;
        exam3.code = "GHJ123";
        exam3.category = categoryQuestion1;
        exam3.Creator =acc1;
        exam3.Duration = 80;
        exam3.title = "Java";
        exam3.createDate = LocalDate.now();

        // ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion();
        examQuestion1.exam = exam1;
        examQuestion1.question = question1;

        ExamQuestion examQuestion2 = new ExamQuestion();
        examQuestion2.exam = exam1;
        examQuestion2.question = question1;

        ExamQuestion examQuestion3 = new ExamQuestion();
        examQuestion3.exam = exam1;
        examQuestion3.question = question1;


        // in ra thông tin của department
        System.out.println("id là:" + dep1.id);
        System.out.println("name là:" + dep1.name);

        // in ra thông tin của account
        System.out.println("id là:" + acc1.id);
        System.out.println("username là:" + acc1.username);
        System.out.println("fullname là:" +  acc1.fullname);
        System.out.println("department là:" +  acc1.department.name);
        System.out.println("position là:" +  acc1.position.name);
        System.out.println("creatdate là:" +  acc1.createDate);

        // in ra thông tin của position
        System.out.println("id là:" + pos1.id);
        System.out.println("name là:" + pos1.name);

        // in ra thông tin của Group
        System.out.println("id là:" + Group1.id);
        System.out.println("id là:" + Group1.name);
        System.out.println("creator là:" + Group1.creator.fullname);
        System.out.println("createDate là:" + Group1.createDate);

        // in ra thông tin của GroupAccount
        System.out.println("group là:" + groupAccount1.group);
        System.out.println("account là:" + groupAccount1.account);
        System.out.println("joinDate là:" + groupAccount1.joinDate);

        // in ra thông tin của TypeQuestion
        System.out.println("id là:" + typeQuestion1.id);
        System.out.println("name là:" + typeQuestion1.name);

        // in ra thông tin của CategoryQuestion
        System.out.println("id là:" + categoryQuestion1.id);
        System.out.println("name là:" + categoryQuestion1.name);

        // in ra thông tin của Question
        System.out.println("id là:" + question1.id);
        System.out.println("content là:" + question1.content);
        System.out.println("category là:" + question1.category.name);
        System.out.println("createDate là:" + question1.createDate);
        System.out.println("creator là:" + question1.creator);
        System.out.println("type là:" + question1.type.name);

        // in ra thông tin của Answer
        System.out.println("id là:" + answer1.id);
        System.out.println("conten là:" + answer1.conten);
        System.out.println("question là:" + answer1.question);
        System.out.println("isCorrect là:" + answer1.isCorrect);

        // in ra thông tin của Exam
        System.out.println("id là:" + exam1.id);
        System.out.println("code là:" + exam1.code);
        System.out.println("title là:" + exam1.title);
        System.out.println("category là:" + exam1.category);
        System.out.println("Duration là:" + exam1.Duration);
        System.out.println("Creator là:" + exam1.Creator);
        System.out.println("createDate là:" + exam1.createDate);

        // in ra thông tin của ExamQuestion
        System.out.println("exam là:" + examQuestion1.exam);
        System.out.println("question là:" + examQuestion1.question);




























    }
}