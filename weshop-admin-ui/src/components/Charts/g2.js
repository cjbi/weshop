// 全局 G2 设置
import {setTheme, track} from 'bizcharts';

track(false);

const config = {
  defaultColor: '#1089ff',
  shape: {
    interval: {
      fillOpacity: 1,
    },
  },
};

setTheme(config);
