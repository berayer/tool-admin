<template>
  <n-card>
    <v-chart autoresize :option="option" />
  </n-card>
</template>

<script setup lang="ts">
import VChart from 'vue-echarts'
import { EChartsOption } from 'echarts'

const option = ref<EChartsOption>({
  title: {
    text: '订单分布图',
    left: 'center'
  },
  xAxis: {
    type: 'category',
    data: [
      '未提交',
      '待审图',
      '退回',
      '待拆单审核',
      '待拆单复审',
      '待报价审核',
      '待经销商确认',
      '待付款确认',
      '待财务审核',
      '待物料采购',
      '待计划生产',
      '计划已接单',
      '已排生产计划',
      '开始生产',
      '部分入库',
      '全部入库',
      '部分发货'
    ]
  },
  tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'shadow'
    },
    valueFormatter: (value) => `${value} (单)`
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [
        675, 2350, 1125, 981, 132, 41, 1420, 3, 353, 4, 2772, 20, 4118, 2734, 1857, 1328, 1958
      ],
      type: 'bar',
      showBackground: true,
      backgroundStyle: {
        color: 'rgba(180,180,180,0.2)'
      }
    }
  ]
})
</script>
