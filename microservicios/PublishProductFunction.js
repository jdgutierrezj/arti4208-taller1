'use strict';

const AWS      = require('aws-sdk');

exports.handler = (event, context, callback) => {
    
    console.log("input " + JSON.stringify(event, null, 2));
    
    const done = (err, res) => callback(null, {
        statusCode: err ? '400' : '200',
        body: err ? err.message : JSON.stringify(res),
        headers: {
            'Content-Type': 'application/json',
        },
    });

    var stepfunctions = new AWS.StepFunctions();

    var params = {
        stateMachineArn: 'arn:aws:states:us-west-2:227029797649:stateMachine:PublishProductStateMachine', 
        input: event.body
    };

    console.log("params " + JSON.stringify(params, null, 2));
    
    stepfunctions.startExecution(params, done);

};
