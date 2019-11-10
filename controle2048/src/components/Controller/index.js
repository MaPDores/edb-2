import React from 'react';
import {
  View,
} from 'react-native';
import Button from '../Button';
import direction from '../../enumerators/direction';

const Controller = ({ host }) => {
    return (
    <>
    <View style={{ flex: 1, 
       top: 222, left: 157}}>
      <Button host={host} params={{ direction: direction.up, name: "lontra" }} text={'up'}/>
    </View>
    <View style={{ flex: 1, flexDirection: 'row', justifyContent: 'space-around'}}>
        <Button host={host} params={{direction: direction.left, name: "luis"}} text={'left'}/>
        <Button host={host} params={{direction: direction.right, name: "marcelo"}} text={'right'}/>
      </View>
    <View style={{ position: 'absolute', bottom: 170, left: 157}}>
      <Button host={host} params={{direction: direction.down, name: "guaxinin" }} text={'down'}/>
    </View>
    </>
    );
};

export default Controller;
