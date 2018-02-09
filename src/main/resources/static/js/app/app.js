var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/blackjack',
    GAME_SERVICE_API : 'http://localhost:8080/blackjack/game/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'GameController',
                controllerAs:'ctrl'
            });
        $urlRouterProvider.otherwise('/');
    }]);

