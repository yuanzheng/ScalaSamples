<?php
date_default_timezone_set('America/Denver');
use Phinx\Migration\AbstractMigration;

class AddSourceId extends AbstractMigration
{

    private function getSourceKey()
    {
        $sql = $this->query("SELECT source_key FROM test.solutions where id=1");
        $results = $sql->fetchAll(PDO::FETCH_ASSOC);

        echo "Show:\n";
        var_dump($sesults);

        return $results;
    }


    private function updateValueForNewColumn($results)
    {
        $sql= $this->query("UPDATE test.solutions, main.sources SET test.solutions.source_id = main.sources.id where test.solutions.source_key = main.sources.source_key;
");
        print_r("1\n");
        $results = $sql->fetchAll(PDO::FETCH_ASSOC);
        print_r("2\n");
        $sql->closeCursor();

    }


    private function getSourceKeyFromSolutions()
    {
        $sql = $this->query("SELECT DISTINCT source_key FROM test.solutions");
        $results = $sql->fetchAll(PDO::FETCH_ASSOC);
        $sql->closeCursor();
        $source_key = array();
        //print_r($results);
        foreach ($results as $value) {
            # code...
            //echo $value["source_key"] . "\n";
            //print_r($value);
            $source_key[] = $value["source_key"];
        }
        //print_r($source_key);
        return $source_key;
    }

    private function getSourceIdFromSources($source_key)
    {
        $tmp = array();
        foreach ($source_key as $key) {
            echo "key? " . $key . "\n";
            $sql = $this->query("SELECT id FROM main.sources where source_key = '$key'");
            $results = $sql->fetchAll(PDO::FETCH_ASSOC);
            $sql->closeCursor();

            //print_r($results);
            if (!empty($results)) {
                //echo "see: " . $results[0]["id"] . "\n";
                $tmp[$key] = $results[0]["id"];
            }
            
        }
        return $tmp;
    }

    private function updateSolutionsUsingSourceId($key_pairs)
    {
        foreach ($key_pairs as $key => $value) {
            $sql = $this->query("UPDATE test.solutions SET test.solutions.source_id = '$value' WHERE source_key = '$key'");
            $sql->closeCursor();
        }

    }

    private function updates()
    {
        $sql = $this->query();
    }

    /**
     * Migrate Up.
     */
    public function up()
    {
        $sql = <<<ENDSQL
        ALTER TABLE `test`.`solutions`
        ADD COLUMN source_id INT DEFAULT NULL AFTER source_key;

        UPDATE `test`.`solutions`
        INNER JOIN `main`.`sources`
        ON `test`.`solutions`.`source_key` = `main`.`sources`.`source_key`
        SET `test`.`solutions`.`source_id` = `main`.`sources`.`id`;
ENDSQL;
        $this->execute($sql);
/*
        $source_keys = $this->getSourceKeyFromSolutions();
        print_r($source_keys);
        $source_ids = $this->getSourceIdFromSources($source_keys);
        print_r($source_ids);
        $this->updateSolutionsUsingSourceId($source_ids);
*/
    }



    /**
     * Migrate Down.
     */
    public function down()
    {
        $sql = <<<ENDSQL
        ALTER TABLE `test`.`solutions`
        DROP COLUMN `source_id`;
ENDSQL;

        $this->execute($sql);

    }
}