var departments = []; // mảng chứa departments
var v_idUpdate = -1;
var vTheme = "";
var baseUrl = "http://localhost:8080/api/v1/departments";
var baseAvt =
    "https://images2.thanhnien.vn/528068263637045248/2024/1/25/e093e9cfc9027d6a142358d24d2ee350-65a11ac2af785880-17061562929701875684912.jpg";

loadData(); // load ra ds account

// load màu nên ở localStorage
vTheme = localStorage.getItem("theme");
changeTheme(vTheme);

function changeTheme(themeValue) {
    if (themeValue === "dark") {
        // thêm class .dark-theme vào body
        $("body").addClass("dark-theme");
    } else {
        $("body").removeClass("dark-theme");
    }
    localStorage.setItem("theme", themeValue);
}

function loadData() {
    // call api đến mockapi.io đe lấy ds department
    // jqAjax
    $.ajax({
        type: "GET",
        url: baseUrl,
        dataType: "JSON",
        success: function (response) {
            // call api thanh cong
            department = response;
            var tableContent = "";
            for (let i = 0; i < department.length; i++) {
                tableContent += "<tr>";
                tableContent += "<td>" + department[i].id + "</td>";
                tableContent +=
                    "<td><img src=" +
                    baseAvt +
                    " style='height: 50px' alt='Image' /></td>";
                tableContent += "<td>" + department[i].name + "</td>";              
                tableContent +=
                    "<td><button onclick='onHandleEdit(" +
                    department[i].id +
                    ")'>Edit</button> " +
                    " <button onclick='onDelete(" +
                    department[i].id +
                    ")'>Delete</button></td>";
                tableContent += "</tr>";
            }
            //         {
            //     "id": 1,
            //     "username": "annguyen1",
            //     "fullName": "Nguyễn Văn An",
            //     "departmentName": "Marketing",
            //     "positionName": "DEV"
            // },
            // trước khi show data thì clear bảng trước
            //jqEmpty
            $("#tableBoby").empty();
            // jqAppend
            $("#tableBoby").append(tableContent);
        },
        error: function (error) {
            alert("Call api get department thất bại");
        },
    });
}

function onDelete(idDelete) {
    var check = confirm("Bạn có chắc chắn xóa account này?");
    if (check) {
        $.ajax({
            type: "DELETE",
            url: baseUrl + "/" + idDelete,
            success: function (response) {
                alert("Xóa thành công!");
                loadData();
            },
            error: function (error) {
                alert("Call api xóa thất bại");
            },
        });
    }
}

function onCreate(idDelete) {
    if (v_idUpdate > 0) {
        alert("Đang update, ko thể tạo mới dc");
        return;
    }
    var v_avatar = $("#inputAvatar").val();
    var v_name = $("#inputName").val();

    // đưa các dữ liệu trên vào object // object của js
    var department = {
        name: v_name,
    };
    //https://images2.thanhnien.vn/528068263637045248/2024/1/25/e093e9cfc9027d6a142358d24d2ee350-65a11ac2af785880-17061562929701875684912.jpg
    // call api dể thêm mới department
    $.ajax({
        type: "POST",
        url: baseUrl,
        data: JSON.stringify(department), // chuyển account từ obejct của JS thành JSON
        contentType: "application/json",
        success: function (response) {
            alert("Thêm dữ liệu thành công");
            // hiển thị lại ds department
            loadData();
            // clear dữ lieu 3 ô username, fullName, age ở tren
            //jqValSet
            $("#inputAvatar").val("");          
            $("#inputName").val("");
            $("#modal-id").modal("hide");
        },
        error: function (error) {
            alert("Call api thêm mới thất bại");
        },
    });
}

// jqSubmit
// $("#accountForm").submit(function (e) {
//     e.preventDefault();

// });

$("#submit").click(function (e) {
    // nếu v_idUpdate <= 0    thì sẽ tạo mới
    // nếu v_idUpdate > 0 thì sẽ update
    if (v_idUpdate <= 0) {
        onCreate();
    } else {
        onUpdate();
    }
});

function resetForm() {
    $(".modal-title").empty();
    $(".modal-title").append("<div>Create Department</div>");
    $("#inputAvatar").val("");
    $("#inputName").val("");
    v_idUpdate = -1;
}

function onHandleEdit(idUpdate) {
    // mo modal
    $("#modal-id").modal("show");
    // call api get by id đẻ lấy lấy dữ liệu ra để hiển thị lên các ô input
    $.ajax({
        type: "GET",
        url: baseUrl + "/" + idUpdate,
        dataType: "JSON",
        success: function (response) {
            $(".modal-title").empty();
            $(".modal-title").append("<div>Update Department</div>");
            // hien thi ra cac o input tuong ung
            $("#inputAvatar").val(response.avatar);
            $("#inputName").val(response.name);
            v_idUpdate = idUpdate; // lưu lại id cần update
        },
        error: function (error) {
            alert("Call api lấy thông tin thất bại");
        },
    });
}

function onUpdate(idDelete) {
    var v_avatar = $("#inputAvatar").val();
    var v_email = $("#inputName").val();
    // lay ra doi tuong can update
    var departmentUpdate = {
        name : v_name,
    };
    // call api update
    $.ajax({
        type: "PUT",
        url: baseUrl + "/" + v_idUpdate,
        data: JSON.stringify(departmentUpdate),
        contentType: "application/json",
        success: function (response) {
            alert("Update dữ liệu thành công");
            // hiển thi ls account
            loadData();
            //jqValSet
            v_idUpdate = -1;
            $("#inputAvatar").val("");
            $("#inputName").val("");
            $("#modal-id").modal("hide");
        },
        error: function (error) {
            alert("Call api update thất bại");
        },
    });
}


