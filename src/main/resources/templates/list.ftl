<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">BlackJack</span></div>
        <div class="panel-body">
            <div class="gameContainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <div class="alert alert-info-" role="alert" ng-if="ctrl.infoMessage">{{ctrl.outcomeOfTheGameMessage}}</div>
                <div>
                    <h1>Simple BlackJack game</h1>
                    <h1>Press start to try it</h1>
                    <button type="button" ng-click="ctrl.createGame()" class="btn-info"">Deal</button>
                </div>
                <div class="row" ng-model="btnContainer" ng-if="dealBtn">
                    <div class="form-actions floatRight">
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Hit</button>
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Stand</button>
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Start new game</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>