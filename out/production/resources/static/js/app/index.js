var main = {
      init : function () {
          var _this = this;

          $('#btn-send').on('click', function () {
              _this.send();
          })
      },

      send : function () {
          var reply;
          var status;
          var responseMessage;

          var data = {
              typedMessage: $('#typing').val(),
          };

          $.ajax({
              type: 'POST',	// {3}
              url: '/api/chatbot/answer',	// {4}
              dataType: 'json',
              contentType: 'application/json; charset=utf-8',
              data: JSON.stringify(data),
              success : function(res){
                reply = res["answer"];
                status = res["status"];
                responseMessage = res["responseMessage"];
              }
          }).done(function(res) {
              //alert('메시지: ' + reply);
              $('#replies').append(reply + "\n");
              //window.location.href = '/';
          }).fail(function (error) {
              alert(JSON.stringify(error));
          });
      }
  };

  main.init();