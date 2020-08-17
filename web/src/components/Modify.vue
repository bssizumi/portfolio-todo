<template>
  <v-card>
    <v-form ref="form" v-model="valid">
      <v-card-title>
        <span class="headline">TODO</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="12">
              <v-text-field
                v-model="form.title"
                label="タイトル*"
                :counter="30"
                :rules="titleRules"
                required
              ></v-text-field>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12">
              <v-textarea v-model="form.body" label="内容"></v-textarea>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12">
              <v-menu
                v-model="menu"
                :close-on-content-click="false"
                transition="scale-transition"
                offset-y
                max-width="290px"
                min-width="290px"
              >
                <template v-slot:activator="{ on }">
                  <v-text-field v-model="form.limitDateTime" label="期限" readonly v-on="on"></v-text-field>
                </template>
                <v-date-picker
                  v-model="form.limitDateTime"
                  no-title
                  @input="menu = false"
                  locale="jp-ja"
                  :day-format="(date) => new Date(date).getDate()"
                ></v-date-picker>
              </v-menu>
            </v-col>
          </v-row>
        </v-container>
        <small>*:必須</small>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="onCancel">キャンセル</v-btn>
        <v-btn color="blue" text @click="onDelete">削除</v-btn>
        <v-btn
          :disabled="!valid"
          color="blue darken-1"
          text
          @click="onSubmit"
        >{{ add ? "追加" : "変更" }}</v-btn>
      </v-card-actions>
    </v-form>
  </v-card>
</template>

<script>
import { postData, TODO_UPDATE, TODO_CREATE, TODO_DELETE } from "../common/API";
import { MUTATION_KEYS } from "../store";
export default {
  name: "Modify",
  props: { listId: Number, propform: Object, add: Boolean, close: Function },
  data() {
    return {
      menu: false,
      valid: true,
      titleRules: [
        (v) => !!v || "入力してください",
        (v) => (v && v.length <= 30) || "30文字以内で入力して下さい",
      ],
      form: { title: "", body: "", limitDateTime: "", ...this.propform },
    };
  },
  methods: {
    async onSubmit() {
      // 登録/更新処理
      const url = this.add ? TODO_CREATE : TODO_UPDATE;
      const data = { ...this.form, listId: this.listId };
      const lists = await postData(url, data);
      this.$store.commit(MUTATION_KEYS.SET_LISTS, lists);
      this.close();
    },
    async onDelete() {
      // 削除処理
      const lists = await postData(TODO_DELETE, { todoId: this.form.todoId });
      this.$store.commit(MUTATION_KEYS.SET_LISTS, lists);
      this.close();
    },
    onCancel() {
      //キャンセル処理
      if (this.add) {
        this.$refs.form.reset();
      } else {
        this.form = { ...this.propform };
        this.$refs.form.resetValidation();
      }
      this.close();
    },
  },
};
</script>
