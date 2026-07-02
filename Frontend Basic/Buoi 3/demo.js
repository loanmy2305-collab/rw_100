            var v_id = 4;
            var v_idUpdate = -1; //lư ại id update
            var arrs = [
                {
                    id: 1,
                    username: "nguyenvana",
                    fullName: "Nguyen Van A",
                    age: 20,
                },
                {
                    id: 2,
                    username: "nguyenvanb",
                    fullName: "Nguyen Van B",
                    age: 21,
                },
                {
                    id: 3,
                    username: "nguyenvanc",
                    fullName: "Nguyen Van C",
                    age: 22,
                },
                {
                    id: 4,
                    username: "nguyenvand",
                    fullName: "Nguyen Van D",
                    age: 23,
                },
            ];

            loadData();

            function loadData() {
                var tableContent = "";
                for (let i = 0; i < arrs.length; i++) {
                    tableContent += "<tr>";
                    tableContent += "<td>" + arrs[i].id + "</td>";
                    tableContent += "<td>" + arrs[i].username + "</td>";
                    tableContent += "<td>" + arrs[i].fullName + "</td>";
                    tableContent += "<td>" + arrs[i].age + "</td>";
                    tableContent +=
                        "<td><button onclick = 'onHandleUpdate(" +
                        arrs[i].id +
                        ")'>Edit</button> <button onclick = 'onDelete(" +
                        arrs[i].id +
                        ")'>Delete</button></td> ";
                    tableContent += "</tr>";
                }

                // document.getElementById("tableBoby").innerHTML = tableContent; // nối dữ liệu vào table body có id=tableboby
                // trước khi sow data thì clear bảng trước
                //jqEmpty
                $("#tableBoby").empty();
                //JqAppend
                $("#tableBoby").append(tableContent);
            }

            function onDelete(idDelete) {
                var comfirm = confirm(
                    "Bạn có chắc chắn xóa account này không?",
                );
                if (comfirm == true) {
                    var indexDelete = -1;
                    for (let i = 0; i < arrs.length; i++) {
                        if (arrs[i].id == idDelete) {
                            indexDelete = i;
                            break;
                        }
                    }
                    arrs.splice(indexDelete, 1);
                    alert("Xóa thành công"); //xóa phần tử theo vị trí,số lượng phần tử muốn xóa
                    loadData(); // hiển thị lại ds
                }
            }

            // jqsubmit
            $("#accountForm").submit(function (e) {
                e.preventDefault();
                if (v_idUpdate > 0) {
                    alert("đang update, không thể tạo mới được ");
                    return;
                }
                var v_username = $("#inputUsername").val();
                var v_fullName = $("#inputFullName").val();
                var v_age = $("#inputAge").val();

                // đưa các dữ liệu trên vào object và thêm arrs
                var account = {
                    id: ++v_id,
                    username: v_username,
                    fullName: v_fullName,
                    age: v_age,
                };
                arrs.push(account);
                alert("Thêm dữ liệu thành công");
                // hiển thị lại danh sách account
                loadData();
                // clear dữ liệu 3 ô username,fullname,age ở trên
                $("#inputUsername").val("");
                $("#inputFullName").val("");
                $("#inputAge").val("");
            });

            function onHandleUpdate(idUpdate) {
                // đưa vào id đê show dữ liệu lên các ô trên
                for (let i = 0; i < arrs.length; i++) {
                    if (arrs[i].id == idUpdate) {
                        // hiển thị dữ liệu trên
                        $("#inputUsername").val(arrs[i].username);
                        $("#inputFullName").val(arrs[i].fullName);
                        $("#inputAge").val(arrs[i].age);
                        v_idUpdate = idUpdate; // lưu lại id cần update
                        break;
                    }
                }
            }

            function onUpdateAccount() {
                
                var v_username = $("#inputUsername").val();
                var v_fullName = $("#inputFullName").val();
                var v_age = $("#inputAge").val();
                // tìm vị trí của objject cần ud=pdate trong mảng
                var v_indexUpdate = -1;

                // for (let i = 0; i < arrs.length; i++) {
                //     if (arrs[i].id == v_idUpdate) {
                //         v_indexUpdate = i;
                //         break;
                //     }
                // }

                v_indexUpdate = arrs.findIndex((i) => i.id == v_idUpdate);
                // update gtri ở ctri thứ 1 = gtri nhập từ màn hình
                if (v_idUpdate == -1) {
                    alert("phần tử này không tồn tại,hoặc đang tạo mới");
                } else {
                    arrs[v_indexUpdate] = {
                        id: v_idUpdate,
                        username: v_username,
                        fullName: v_fullName,
                        age: v_age,
                    };
                    alert("Thêm dữ liệu thành công");
                    // hiển thị lại danh sách account
                    loadData();
                    // clear dữ liệu 3 ô username,fullname,age ở trên
                    v_idUpdate = -1;
                    $("#inputUsername").val("");
                    $("#inputFullName").val("");
                    $("#inputAge").val("");
                }
            }
