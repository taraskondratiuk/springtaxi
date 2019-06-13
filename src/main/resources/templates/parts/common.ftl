<#macro page>
    <#import "/spring.ftl" as spring/>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Taxi app</title>
        <link rel="stylesheet" type="text/css"
              href="<@spring.url '/css/bootstrap.css'/>"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css"
              href="<@spring.url '/css/styles.css'/>"/>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
        <script type="text/javascript">

            var app = angular.module('ngpatternApp', []);

            app.controller('ngpatternCtrl', function () {

            });

        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
        </script>
        <script type="application/javascript">
            function switchUA() {
                window.location.replace(window.location.origin + window.location.pathname + '?lang=UA');
            }

            function switchUS() {
                window.location.replace(window.location.origin + window.location.pathname + '?lang=US');
            }
        </script>
        <script>
            var app = angular.module('selectboxApp', []);
            app.controller('selectboxCtrl', function ($scope) {

                $scope.checkselection = function () {
                    setTimeout(function () {

                    $scope.msg = '';
                    if ($scope.placeStart == "" || $scope.placeStart == undefined ||
                        $scope.placeEnd == "" || $scope.placeEnd == undefined ||
                    $scope.typeCar == "" || $scope.typeCar == undefined)

                        $scope.msg = 'Please Select All Dropdown Values';
                    if ($scope.placeStart == $scope.placeEnd)
                        $scope.msg = 'Please choose different init and dest places';
                    if($scope.msg == '')

                        angular.element('#mysubmit').trigger('click');
                    }, 0);
                }
            });
        </script>
        <script>
            var compareTo = function() {
                return {
                    require: "ngModel",
                    scope: {
                        otherModelValue: "=compareTo"
                    },
                    link: function(scope, element, attributes, ngModel) {

                        ngModel.$validators.compareTo = function(modelValue) {
                            return modelValue != scope.otherModelValue;
                        };

                        scope.$watch("otherModelValue", function() {
                            ngModel.$validate();
                        });
                    }
                };
            };

            module.directive("compareTo", compareTo);
        </script>
    </head>
    <body>
    <#include "header.ftl"/>
    <section class="page-wrapper container">
        <#nested/>
    </section>
    <#include "footer.ftl"/>
    </body>



    </html>
</#macro>