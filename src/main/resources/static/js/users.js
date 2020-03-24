$(document).ready(function () {
        // AJAX-запрос с помощью функции getJSON
        //   url - адрес запроса
        //   success - обработка данных при успешном ответе сервера
        $.getJSON({
            url: 'http://localhost:8080/api/users',
            success: function (data) {
                // переменная, для хранения результата
                var output = '';
                // переберём всех пользователей
                data.forEach(function (item) {
                    output += '<tr>';
                    output += '<td><span>' + item.id + '</span></td>';
                    output += '<td><span>' + item.username + '</span></td>';
                    output += '<td><span>' + item.password + '</span></td>';
                    output += '<td><span>' + item.name + '</span></td>';
                    // output += '<td><span>' + item.role + '</span></td>';
                    for (let i in item.role) {
                        output += '<td><span>' + item.role.role + '</span></td>';
                    }
                    output += '<td>';

                    output += '</td>';
                    output += '<td>';

                    output += '</td>';
                    output += '</tr>';
                })

                // <td><span th:text="${user.id}"/></td>
                //                                 <td><span th:text="${user.username}"/></td>
                //                                 <td><span th:text="${user.password}"/></td>
                //                               <td><span th:text="${user.name}"/></td>
                //                               <td><span th:each="role: ${user.roles}" th:text="${role.role}"/></td>
                // }
                // вставим список в элемент с id="users"
                $('#users').empty().append(output);
            }
        });
    }
)