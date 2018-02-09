var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/blackjack',
    USER_SERVICE_API : 'http://localhost:8080/blackjack/game/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'GameController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, GameService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        GameService.loadAllGames().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

