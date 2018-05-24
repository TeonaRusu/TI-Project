using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DesktopApp
{
    public partial class Form1 : Form
    {
        private string username;

        public Form1()
        {
            InitializeComponent();
    
            // Create a request for the URL. 		
            WebRequest request = WebRequest.Create("http://localhost:1234/TuxyDriveSSW/rest/hello");
            // If required by the server, set the credentials.
            request.Credentials = CredentialCache.DefaultCredentials;
            // Get the response.
            HttpWebResponse response = (HttpWebResponse)request.GetResponse();
            // Display the status.
            Console.WriteLine(response.StatusDescription);
            // Get the stream containing content returned by the server.
            Stream dataStream = response.GetResponseStream();
            // Open the stream using a StreamReader for easy access.
            StreamReader reader = new StreamReader(dataStream);
            // Read the content.
            string responseFromServer = reader.ReadToEnd();
            // Display the content.
            Console.WriteLine(responseFromServer);
            string[] words = responseFromServer.Split('#');
            int j = 0;
            dataGridView1.Rows[0].Cells[0].Value = words[1];
            dataGridView1.Rows[0].Cells[1].Value = words[2];
            dataGridView1.Rows[0].Cells[2].Value = words[3];
      
            //dataGridView1.Rows[1].Cells[0].Value = words[4];
           // dataGridView1.Rows[2].Cells[1].Value = words[6];
          //  dataGridView1.Rows[3].Cells[2].Value = words[7];
            // dataGridView1.Rows[j].Cells[i + 1].Value = words[i + 1];
            for (int i= 1; i < words.Count()-1; i++)
            {
               // dataGridView1.Rows[j].Cells[j].Value = words[i];
               // dataGridView1.Rows[j].Cells[j+1].Value = words[i+1];
                j++;
                if(words[i] == "aici")
                {
                    j++;
                }
            }
           
            label1.Text = responseFromServer;
            // Cleanup the streams and the response.
            reader.Close();
            dataStream.Close();
            response.Close();

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
          
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
