import React, { useState } from 'react';
import {
  TextInput,
} from 'react-native';
import Controller from './components/Controller';
// import GestureTracker from './components/GestureTracker';

const App = () => {
  const [host, setHost] = useState('localhost');
  return (
    <>
      <TextInput onChangeText={text => setHost(text)}/>
      <Controller host={host}/>
    </>
    );
};

export default App;
