console.clear();
angular.module('fileUpload', [])
  .controller("upload", ['$scope', '$http', 'uploadService', function($scope, $http, uploadService) {
    $scope.$watch('file', function(newfile, oldfile) {
      if(angular.equals(newfile, oldfile) ){
        return;
      }

      uploadService.upload(newfile);
    });

  }])
  .service("uploadService", function($http, $q) {

    return ({
      upload: upload
    });

    function upload(file) {
        localStorage.setItem("imagen", file)
    }

    function handleError(response, data) {
      if (!angular.isObject(response.data) ||!response.data.message) {
        return ($q.reject("An unknown error occurred."));
      }

      return ($q.reject(response.data.message));
    }

    function handleSuccess(response) {
      return (response);
    }

  })
  .directive("fileinput", [function() {
    return {
      scope: {
        fileinput: "=",
        filepreview: "="
      },
      link: function(scope, element, attributes) {
        element.bind("change", function(changeEvent) {
          scope.fileinput = changeEvent.target.files[0];
          var reader = new FileReader();
          reader.onload = function(loadEvent) {
            scope.$apply(function() {
              scope.filepreview = loadEvent.target.result;
            });
          }
          reader.readAsDataURL(scope.fileinput);
        });
      }
    }
  }]);