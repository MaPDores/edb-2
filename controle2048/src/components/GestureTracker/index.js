import React from 'react';
import {
  View,
  PanResponder,
} from 'react-native';

import direction from '../../enumerators/direction';
import { sendDirection } from '../../services/control';

export default class GestureTracker extends React.PureComponent {
      
    componentWillMount() {
        this.pan = PanResponder.create({
            onStartShouldSetPanResponder: (evt, gestureState) => true,
            onStartShouldSetPanResponderCapture: (evt, gestureState) => true,
            onMoveShouldSetPanResponder: (evt, gestureState) => true,
            onMoveShouldSetPanResponderCapture: (evt, gestureState) => true,

            onPanResponderRelease: (evt, gestureState) => {
                const {moveX, moveY} = gestureState;
                console.log({moveX, moveY});
                if (gestureState.moveX > 0 && gestureState.moveY < 0) {
                    gestureState.moveY = (gestureState.moveY * (-1));
                    if (gestureState.moveX > gestureState.moveY) {
                        sendDirection(direction.right);
                    }
                    else if(gestureState.moveX < gestureState.moveY) {
                        sendDirection(direction.down);
                    }
                } else if (gestureState.moveX > 0 && gestureState.moveY > 0) {
                    if (gestureState.moveX > gestureState.moveY) {
                        sendDirection(direction.right);
                    } else if(gestureState.moveX < gestureState.moveY) {
                        sendDirection(direction.up);
                    }
                } else if (gestureState.moveX < 0 && gestureState.moveY > 0) {
                    gestureState.moveX = (gestureState.moveX * (-1));
                    if (gestureState.moveX > gestureState.moveY) {
                        sendDirection(direction.left);
                    } else if(gestureState.moveX < gestureState.moveY) {
                        sendDirection(direction.up);
                    }
                } else if (gestureState.moveX < 0 && gestureState.moveY < 0) {
                    if (gestureState.moveX > gestureState.moveY) {
                        sendDirection(direction.down);
                    } else if(gestureState.moveX < gestureState.moveY) {
                        sendDirection(direction.left);
                    }
                }
            }
      });
    }

    render() {
        return (
                <View {...this.pan.panHandlers} style={{flex: 1}}/>);
    }
}