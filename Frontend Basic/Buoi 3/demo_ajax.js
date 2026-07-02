 var accounts = []; //mảng chứa acc
 var v_idUpdate = -1; //lư ại id update
 var vTheme = '';

 loadData() ;
 // note màu nền ở localStorage
 var vTheme = localStorage.getItem("theme");
 changeTheme();


 function loadData() {
    //call api đến moclapi.io để lấy ds acc
    //jqajax
    $.ajax({
        type: "GET",
        url: "https://6a3bc82ee4a07f202e15d76b.mockapi.io/api/v1/account",
        // data: "data", --phuc  vụ cho thêm hoặc update
        dataType: "JSON",
        success: function (response) { // call api thành công
            accounts = response;
             var tableContent = "";
                for (let i = 0; i < accounts.length; i++) {
                    tableContent += "<tr>";
                    tableContent += "<td>" + accounts[i].id + "</td>";
                    tableContent += "<td><img src= " + accounts[i].avatar + " style= 'height: 50px' alt = 'Image'/> </td>";
                    tableContent += "<td>" + accounts[i].username + "</td>";
                    tableContent += "<td>" + accounts[i].fullName + "</td>";
                    tableContent += "<td>" + accounts[i].age + "</td>";
                    tableContent +=
                        "<td><button onclick = 'onHandleEdit(" +
                        accounts[i].id +
                        ")'>Edit</button> <button onclick = 'onDelete(" +
                        accounts[i].id +
                        ")'>Delete</button></td> ";
                    tableContent += "</tr>";
                }
                $("#tableBoby").empty();
                //JqAppend
                $("#tableBoby").append(tableContent);
        },
        error: function(error){
            alert("Call api get account thất bại");
        }
        
    });
}

function onDelete(idDelete) {
    var check = confirm("Bạn có chắc chắn xóa account này?");
    if(check ){

    // dùng ajax  dể call api xóa
    $.ajax({
        type: "DELETE",
        url: "https://6a3bc82ee4a07f202e15d76b.mockapi.io/api/v1/account/" + idDelete,
        // data: "data",
        // dataType: "dataType",
        success: function (response) {
            alert("xóa thành công!");
            loadData();   
        },
        error: function(error){
            alert("Call api xóa thất bại");
        }
    });
}
}    

//jqclick
function onCreate(idDelete) { 
        if (v_idUpdate > 0) {
                alert("đang update, không thể tạo mới được ");
                    return;
                }
                
                var v_avatar = $("#inputAvatar").val();
                var v_username = $("#inputUsername").val();
                var v_fullName = $("#inputFullName").val();
                var v_age = $("#inputAge").val();

                // đưa các dữ liệu trên vào object và thêm arrs
                var account = {   // object của js                
                    avatar: v_avatar,
                    username: v_username,
                    fullName: v_fullName,
                    age: v_age,
                };
                // call API để thêm mới acc
                $.ajax({
                    type: "POST",
                    url: "https://6a3bc82ee4a07f202e15d76b.mockapi.io/api/v1/account",
                    data: JSON.stringify(account),//chuyển acc từ object của JS thành JSON
                    contentType: "application/json",
                    success: function (response) {
                        alert("Thêm dữ liệu thành công");
                        // hiển thị lại danh sách account
                         loadData();
                         // clear dữ liệu 3 ô username,fullname,age ở trên
                         //jqvalset
                         $("#inputAvatar").val("");
                         $("#inputUsername").val("");
                         $("#inputFullName").val("");
                         $("#inputAge").val("");
                         $("#modal-id").modal("hide");

                    },
                    error: function(error){
                        alert("Call api thêm mới  thất bại");
                    },
                });
    
};

//   // jqsubmit
//  $("#accountForm").submit(function (e) {
                
                
$('#submit').click(function (e) { 
    // nếu v_idUpdate <= 0 thì sẽ tạo mới
    // nếu v_idUpdate > 0 thì sẽ update
    if(v_idUpdate <= 0) {
        onCreate();
    } else {
        onUpdate();
    }    
});

 function resetForm(){
    $(".modal-title").empty();
    $(".modal-title").append("<div>Create Account</div>");
    $("#inputAvatar").val("");
    $("#inputUsername").val("");
    $("#inputFullName").val("");
    $("#inputAge").val("");
    v_idUpdate = -1;
 }

function onHandleEdit(idUpdate) {
    // // mo modal
    $("#modal-id").modal("show");
    // call API get by id để lấy dữ liệu ra để hiển thị lên các ô
        $.ajax({
            type: "GET",
            url: "https://6a3bc82ee4a07f202e15d76b.mockapi.io/api/v1/account/" + idUpdate,
            //data: "data",
            dataType: "JSON",
            success: function (response) {
                $(".modal-title").empty();
                $(".modal-title").append("<div>Update Account</div>");
                
                //hiển thị ra các input tiowng ứng           
                 $("#inputAvatar").val(response.avatar);
                 $("#inputUsername").val(response.username);
                 $("#inputFullName").val(response.fullName);
                 $("#inputAge").val(response.age);
                 v_idUpdate = idUpdate; // lưu lại id cần update
            },
            error: function(error){
                alert("Call api lấy thông tin  thất bại");
            },
        });    
                
     }            

function onUpdate(idDelete) {
        var v_avatar = $("#inputAvatar").val();
        var v_username = $("#inputUsername").val();
        var v_fullName = $("#inputFullName").val();
        var v_age = $("#inputAge").val();

        // đưa các dữ liệu trên vào object và thêm arrs
        var accountUpdate = {   // object của js                
            avatar: v_avatar,
            username: v_username,
            fullName: v_fullName,
            age: v_age,
        };
        // call API để thêm mới acc
            
            $.ajax({
                type: "PUT",
                url: "https://6a3bc82ee4a07f202e15d76b.mockapi.io/api/v1/account/" +v_idUpdate,
                data: JSON.stringify(accountUpdate),
                contentType: "application/json",
                success: function (response) {
                    alert("Thêm dữ liệu thành công");
            // hiển thị lại danh sách account
            loadData();
            // clear dữ liệu 3 ô username,fullname,age ở trên
            v_idUpdate = -1;
            $("#inputAvatar").val("");
            $("#inputUsername").val("");
            $("#inputFullName").val("");
            $("#inputAge").val("");
            $("#modal-id").modal("hide");
                },
            error: function (error){
                alert("Call api lấy thông tin  thất bại");
            },
        
            });
};

function changeTheme(themeValue){
    if(themeValue === 'dark'){
        //thêm class="dark-theme" vào boddy
        $("body").addClass("dark-theme");
    } else {
        $("body").removeClass("dark-theme");
    }
    localStorage.setItem('theme', themeValue)
}
            
    