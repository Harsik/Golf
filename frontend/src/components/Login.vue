<template>
  <v-layout align-center justify-center>
    <v-flex xs12 sm8 md4>
      <v-form>
        <v-text-field v-model='id' :counter='10' data-vv-name='username' label='ID'></v-text-field>
        <v-text-field v-model='password' data-vv-name='password' label='Password'></v-text-field>
        <v-card-actions>
          <v-btn type='submit' @click='submit' color='success'>submit</v-btn>
        </v-card-actions>
      </v-form>
    </v-flex>
  </v-layout>
</template>

<script>
export default {
  data: () => ({
    id: '',
    password: ''
  }),
  methods: {
    // eslint-disable-next-line
    submit() {
      const headers = new Headers({
        'Access-Control-Allow-Origin': '*',
        // 'Content-Type': 'application/json'
        'Content-Type': 'application/x-www-form-urlencoded'
      })
      // fetch('http://192.168.137.59:8080/Alpha/api/auth/signin', {
      fetch('http://localhost:8081/login', {
        method: 'POST',
        headers: headers,
        // mode: 'cors',
        body: 'username=' + this.id + '&password=' + this.password
        // body: JSON.stringify({ username: this.id, password: this.pw })
      })
        .then(response => {
          this.$router.push('/Alert')
          // eslint-disable-next-line
          console.log(response)
          // 로그인이 성공했다는 조건문과 전역 변수 만들기
          // 백엔드 프론트 엔드 별도 서버 운영 시도해보기
        })
        .catch(error => {
          // eslint-disable-next-line
          console.log(error)
        })
    }
  }
}
</script>
