<template>
  <div class="q-pt-md row justify-center">
    <div class="q-pa-sm col-xl-9 col-lg-9 col-md-10 col-sm-12 col-xs-12">
      <q-stepper
        v-model="step"
        ref="stepper"
        color="primary"
        animated
        class="q-py-md q-gutter-col-md"
      >
        <q-step
          :name="1"
          title="业务介绍"
          icon="settings"
          :done="step > 1"
          style="min-height: 200px"
        >
          <p>业务介绍！</p>
        </q-step>

        <q-step
          :name="2"
          title="提交申请"
          icon="create_new_folder"
          :done="step > 2"
          style="min-height: 300px"
        >
          <q-chip class="glossy disabled " icon="directions"
            >填写申请理由</q-chip
          >
          <note-editer @updateNoteValue="getNote" />
        </q-step>

        <q-step
          :name="3"
          title="等待医生预约洽谈"
          icon="assignment"
          :done="step > 3"
          style="min-height: 200px"
        >
          This step won't show up because it is disabled.
        </q-step>

        <q-step
          :name="4"
          title="确认签约"
          icon="add_comment"
          :done="step > 4"
          style="min-height: 200px"
        >
          Try out different ad text to see what brings in the most customers,
          and learn how to enhance your ads using features like ad extensions.
          If you run into any problems with your ads, find out how to tell if
          they're running and how to resolve approval issues.
        </q-step>

        <q-step
          :name="5"
          title="等待医生确认签约"
          icon="add_comment"
          :done="step > 5"
          style="min-height: 200px"
        >
          Try out different ad text to see what brings in the most customers,
          and learn how to enhance your ads using features like ad extensions.
          If you run into any problems with your ads, find out how to tell if
          they're running and how to resolve approval issues.
        </q-step>

        <q-step
          :name="6"
          title="查看申请结果"
          icon="add_comment"
          :done="step > 6"
          style="min-height: 200px"
        >
          你于 xxxx年xx月xx日 xx:xx 完成了与 xxx医生(编号0102) 的签约
        </q-step>

        <template v-slot:navigation>
          <q-stepper-navigation>
            <q-btn
              v-if="step <= 2"
              @click="goFoward"
              color="primary"
              :label="step === 1 ? '提出申请' : '提交申请'"
            />

            <q-btn
              v-if="step === 3 || step === 5"
              @click="goFowardWithDelay"
              :loading="loading1"
              color="primary"
              style="width: 150px"
            >
              下一步
              <template v-slot:loading>
                <q-spinner-hourglass class="on-left" />
                请等待医生确认...
              </template>
            </q-btn>

            <q-btn
              v-if="step === 2"
              flat
              color="primary"
              @click="goBack"
              label="上一步"
              class="q-ml-sm"
            />

            <div v-if="step === 4" class="q-gutter-sm">
              <q-btn @click="goFoward" color="primary" label="确认签约" />
              <q-btn color="red" label="拒绝签约" />
            </div>
          </q-stepper-navigation>
        </template>

        <template v-slot:message>
          <q-banner v-if="step === 1" class="bg-purple-8 text-white q-px-lg">
            签约前请向工作人员仔细了解"健康管家业务"
          </q-banner>
          <q-banner
            v-else-if="step === 2"
            class="bg-orange-8 text-white q-px-lg"
          >
            提交后会创建一个申请项
          </q-banner>
          <q-banner
            v-else-if="step === 3 || step === 5"
            class="bg-green-8 text-white q-px-lg"
          >
            等待医生预约您的洽谈
          </q-banner>
          <q-banner
            v-else-if="step === 4"
            class="bg-orange-8 text-white q-px-lg"
          >
            请尽快联系医生并完成约谈，协商后再确认签约
          </q-banner>
          <q-banner v-else class="bg-green-8 text-white q-px-lg">
            恭喜您！您已完成健康管家签约程序！
          </q-banner>
        </template>
      </q-stepper>
    </div>
  </div>
</template>

<script>
import NoteEditer from "components/note-editer";

export default {
  data() {
    return {
      step: 1,
      loading1: false,
      applyNote: null // 客户申请说明
    };
  },
  components: {
    NoteEditer
  },
  methods: {
    goFowardWithDelay() {
      this.loading1 = true;

      setTimeout(() => {
        this.loading1 = false;
        this.$refs.stepper.next();
      }, 2000);
    },
    goFoward() {
      this.$refs.stepper.next();
    },
    goBack() {
      this.$refs.stepper.previous();
    },
    getNote(val) {
      // step 2; updateNoteValue event
      this.applyNote = val;
      this.$q.notify({
        message: this.applyNote,
        color: "green",
        position: "top"
      });
    }
  }
};
</script>
