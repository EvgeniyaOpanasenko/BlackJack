'use strict';

angular.module('crudApp').controller('GameController',
    ['GameService', '$scope',  function( GameService, $scope) {

        var self = this;
        self.game = {};
        self.games=[];

        self.submit = submit;
        self.getAllGames = getAllGames;
        self.createGame = createGame;
        self.updateGame = updateGame;
        self.editGame = editGame;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.infoMessage = ''; // when game is over. To show the score
        self.done = false;

        function submit() {
            console.log('Submitting');
            if (self.game.id === undefined || self.game.id === null) {
                console.log('Saving New Game', self.game);
                createGame(self.game);
            } else {
                updateGame(self.game, self.game.id);
                console.log('Game updated with id ', self.game.id);
            }
        }

        function createGame(game) {
            console.log('About to create game');
            GameService.createGame(game)
                .then(
                    function (response) {
                        console.log('Game created successfully');
                        self.successMessage = 'Game created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.game={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Game');
                        self.errorMessage = 'Error while creating Game: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }

        function updateGame(game, id){
            console.log('About to update game');
            GameService.updateGame(game, id)
                .then(
                    function (response){
                        console.log('Game updated successfully');
                        self.successMessage='Game updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Game');
                        self.errorMessage='Error while updating Game '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }

        function getAllGames(){
            return GameService.getAllGames();
        }

        function editGame(id) {
            self.successMessage='';
            self.errorMessage='';
            GameService.getGame(id).then(
                function (game) {
                    self.game = game;
                },
                function (errResponse) {
                    console.error('Error while removing game ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.game={};
           // $scope.myForm.$setPristine(); //reset Form is it better to use form?
        }
    }


    ]);